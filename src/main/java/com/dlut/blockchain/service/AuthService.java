package com.dlut.blockchain.service;

import com.dlut.blockchain.entity.User;
import com.dlut.blockchain.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 认证服务 - 极简版本
 * 仅用于管理员登录验证，无需JWT认证
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 验证管理员身份 - 极简版本
     * 仅验证用户名密码是否正确
     */
    public boolean validateAdmin(String username, String password, HttpSession session, HttpServletResponse response) {
        try {
            // 查找用户
            User user = userRepository.findByUsernameOrEmail(username)
                    .orElse(null);


            
            if (user == null) {
                log.warn("管理员验证失败 - 用户不存在: {}", username);
                return false;
            }
            
            // 检查是否是管理员
            if (user.getRole() != User.Role.ADMIN) {
                log.warn("管理员验证失败 - 非管理员用户: {}", username);
                return false;
            }
            
            // 检查用户状态
            if (user.getStatus() != User.UserStatus.ACTIVE) {
                log.warn("管理员验证失败 - 用户状态异常: {} - {}", username, user.getStatus());
                return false;
            }


            
            // 验证密码
            boolean passwordValid = passwordEncoder.matches(user.getPassword(), password);
            if (!passwordValid) {
                log.warn("管理员验证失败 - 密码错误: {}", username);
                return false;
            }
            
            log.info("管理员验证成功: {}", username);
            session.setAttribute("user", user);
            log.info("存入session的user对象是{}",session.getAttribute("user"));
            // 核心修复：创建JSESSIONID的Cookie并写入响应
            Cookie jsessionIdCookie = new Cookie("JSESSIONID", session.getId());
            jsessionIdCookie.setPath("/"); // 关键：让所有路径的请求都携带这个Cookie
            jsessionIdCookie.setHttpOnly(true); // 安全：防止XSS攻击，前端无法通过JS读取（不影响携带）
            jsessionIdCookie.setMaxAge(-1); // 会话级Cookie（关闭浏览器失效，也可设为正数持久化）
            jsessionIdCookie.setSecure(false); // 非HTTPS环境设为false，HTTPS需设为true
            response.addCookie(jsessionIdCookie);
            return true;
            
        } catch (Exception e) {
            log.error("管理员验证异常: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 检查用户是否存在（用于隐藏入口）
     */
    public boolean checkUserExists(String username) {
        return userRepository.findByUsernameOrEmail(username).isPresent();
    }
}