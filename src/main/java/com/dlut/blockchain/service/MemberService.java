package com.dlut.blockchain.service;

import com.dlut.blockchain.dto.MemberDto;
import com.dlut.blockchain.entity.Member;
import com.dlut.blockchain.repository.MemberRepository;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 实验室成员服务
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 获取所有成员（分页）
     */
    public Page<MemberDto> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable)
                .map(this::convertToDto);
    }

    /**
     * 获取所有活跃成员
     */
    public List<MemberDto> getAllActiveMembers() {
        return memberRepository.findByStatusOrderByDisplayOrderAsc(Member.MemberStatus.ACTIVE)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * 获取特色成员
     */
    public List<MemberDto> getFeaturedMembers() {
        return memberRepository.findByFeaturedTrue(Pageable.unpaged())
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * 根据ID获取成员
     */
    public MemberDto getMemberById(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        return convertToDto(member);
    }

    /**
     * 根据学号获取成员
     */
    public MemberDto getMemberByStudentId(String studentId) {
        Member member = memberRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        return convertToDto(member);
    }

    /**
     * 根据角色获取成员
     */
    public List<MemberDto> getMembersByRole(Member.MemberRole role) {
        return memberRepository.findByRole(role, Pageable.unpaged())
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * 根据年级获取成员
     */
    @Timed(value = "service.members.byGrade", description = "Time taken to get members by grade")
    @Cacheable(value = "members", key = "'grade:' + #grade")
    public List<MemberDto> getMembersByGrade(String grade) {
        return memberRepository.findByGrade(grade, Pageable.unpaged())
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * 搜索成员
     */
    @Timed(value = "service.members.search", description = "Time taken to search members")
    @Cacheable(value = "members", key = "'search:' + #keyword")
    public List<MemberDto> searchMembers(String keyword) {
        return memberRepository.searchMembers(keyword, Pageable.unpaged())
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * 创建成员
     */
    @Transactional
    public MemberDto createMember(MemberDto memberDto) {
        // 检查学号是否已存在
        if (memberRepository.existsByStudentId(memberDto.getStudentId())) {
            throw new RuntimeException("学号已存在");
        }

        Member member = convertToEntity(memberDto);
        Member savedMember = memberRepository.save(member);
        log.info("创建成员成功: {} - {}", savedMember.getStudentId(), savedMember.getName());
        return convertToDto(savedMember);
    }

    /**
     * 更新成员
     */
    @Transactional
    public MemberDto updateMember(Long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        log.debug("hahahaha{}", member);

        // 如果学号发生变化，检查新学号是否已存在
        if (!member.getStudentId().equals(memberDto.getStudentId())) {
            if (memberRepository.existsByStudentId(memberDto.getStudentId())) {
                throw new RuntimeException("学号已存在");
            }
        }

        updateEntityFromDto(member, memberDto);
        log.info("member的年级是{}",member.getGrade());
        Member updatedMember = memberRepository.save(member);
        log.debug("更新的曼巴是{}",updatedMember);
        return convertToDto(updatedMember);
    }

    /**
     * 删除成员
     */
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        memberRepository.delete(member);
        log.info("删除成员成功: {} - {}", member.getStudentId(), member.getName());
    }

    /**
     * 更新成员状态
     */
    @Transactional
    public MemberDto updateMemberStatus(Long id, Member.MemberStatus status) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        member.setStatus(status);
        Member updatedMember = memberRepository.save(member);
        log.info("更新成员状态成功: {} - {} -> {}", updatedMember.getStudentId(), updatedMember.getName(), status);
        return convertToDto(updatedMember);
    }

    /**
     * 更新成员显示顺序
     */
    @Transactional
    public void updateDisplayOrder(Long id, Integer displayOrder) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("成员不存在"));
        member.setDisplayOrder(displayOrder);
        memberRepository.save(member);
        log.info("更新成员显示顺序: {} - {} -> {}", member.getStudentId(), member.getName(), displayOrder);
    }

    /**
     * 实体转换为DTO
     */
    private MemberDto convertToDto(Member member) {
        MemberDto dto = new MemberDto();
        dto.setId(member.getId());
        dto.setStudentId(member.getStudentId());
        dto.setName(member.getName());
        dto.setGender(member.getGender());
        dto.setGrade(String.valueOf(Integer.valueOf(member.getGrade())));
        dto.setMajor(member.getMajor());
        dto.setRole(member.getRole());
        dto.setEmail(member.getEmail());
        dto.setPhone(member.getPhone());
        dto.setResearchDirection(member.getResearchDirection());
        dto.setBio(member.getBio());
        dto.setAvatarUrl(member.getAvatarUrl());
        dto.setStatus(member.getStatus());
        dto.setFeatured(member.getFeatured());
        dto.setDisplayOrder(member.getDisplayOrder());
        dto.setGithubUrl(member.getGithubUrl());
        dto.setLinkedinUrl(member.getLinkedinUrl());
        dto.setPersonalWebsite(member.getPersonalWebsite());
        return dto;
    }

    /**
     * DTO转换为实体
     */

    private Member convertToEntity(MemberDto dto) {
        Member member = new Member();

        // 1. 学号：null → 兜底默认值"2024101"，非null则保留原值（优化原三目写法）
        member.setStudentId(String.valueOf(Optional.ofNullable(dto.getStudentId()).orElse("不填学号的要干啥")));

        // 2. 姓名：null → 空字符串（核心字段也可兜底"未知"，按业务调整）
        member.setName(Optional.ofNullable(dto.getName()).orElse(""));

        // 3. 性别：null → 空字符串（也可兜底"未知"）
        member.setGender(Optional.ofNullable(dto.getGender()).orElse(Member.Gender.OTHER));

        // 4. 年级：先判空数字类型的grade，再转字符串（避免grade=null时调用toString()报错）
        member.setGrade(Optional.ofNullable(dto.getGrade())
                .map(String::valueOf) // 非null则转字符串
                .orElse("2024")); // null则兜底空串

        // 5. 专业：null → 空字符串
        member.setMajor(Optional.ofNullable(dto.getMajor()).orElse(""));

        // 6. 角色：null → 兜底"普通成员"（按业务默认角色调整）
        member.setRole(Optional.ofNullable(dto.getRole()).orElse(Member.MemberRole.MEMBER));

        // 7. 邮箱：null → 空字符串
        member.setEmail(Optional.ofNullable(dto.getEmail()).orElse(""));

        // 8. 手机号：null → 空字符串
        member.setPhone(Optional.ofNullable(dto.getPhone()).orElse(""));

        // 9. 研究方向：null → 空字符串
        member.setResearchDirection(Optional.ofNullable(dto.getResearchDirection()).orElse(""));

        // 10. 个人简介：null → 空字符串
        member.setBio(Optional.ofNullable(dto.getBio()).orElse(""));

        // 11. 头像地址：null → 空字符串（也可兜底默认头像URL，如"/default-avatar.png"）
        member.setAvatarUrl(Optional.ofNullable(dto.getAvatarUrl()).orElse(""));

        // 12. 状态：null → 兜底"正常"（按业务状态枚举调整，如"DRAFT"/"ACTIVE"）
        member.setStatus(Optional.ofNullable(dto.getStatus()).orElse(Member.MemberStatus.ACTIVE));

        // 13. 是否精选：null → 兜底false（布尔类型不能为null）
        member.setFeatured(Optional.ofNullable(dto.getFeatured()).orElse(false));

        // 14. 展示顺序：null → 兜底0（数字类型默认排序值）
        member.setDisplayOrder(Optional.ofNullable(dto.getDisplayOrder()).orElse(0));

        // 15. Github地址：null → 空字符串
        member.setGithubUrl(Optional.ofNullable(dto.getGithubUrl()).orElse(""));

        // 16. Linkedin地址：null → 空字符串
        member.setLinkedinUrl(Optional.ofNullable(dto.getLinkedinUrl()).orElse(""));

        // 17. 个人网站：null → 空字符串
        member.setPersonalWebsite(Optional.ofNullable(dto.getPersonalWebsite()).orElse(""));

        return member;
    }

    /**
     * 更新实体
     */
    private void updateEntityFromDto(Member member, MemberDto dto) {
        member.setStudentId(Objects.isNull(dto.getStudentId()) ? member.getStudentId() : dto.getStudentId());
        member.setName(Objects.isNull(dto.getName()) ? member.getName() : dto.getName());
        member.setGender(Objects.isNull(dto.getGender()) ? member.getGender() : dto.getGender());
        member.setGrade(StringUtils.isNotBlank(dto.getGrade()) ? dto.getGrade() : member.getGrade());
        member.setMajor(Objects.isNull(dto.getMajor()) ? member.getMajor() : dto.getMajor());
        member.setRole(Objects.isNull(dto.getRole()) ? member.getRole() : dto.getRole());
        member.setEmail(Objects.isNull(dto.getEmail()) ? member.getEmail() : dto.getEmail());
        member.setPhone(Objects.isNull(dto.getPhone()) ? member.getPhone() : dto.getPhone());
        member.setResearchDirection(Objects.isNull(dto.getResearchDirection())? member.getResearchDirection():dto.getResearchDirection());
        member.setBio(Objects.isNull(dto.getBio()) ? member.getBio() : dto.getBio());
        member.setAvatarUrl(Objects.isNull(dto.getAvatarUrl()) ? member.getAvatarUrl() : dto.getAvatarUrl());
        member.setStatus(Objects.isNull(dto.getStatus()) ? member.getStatus(): dto.getStatus());
        member.setFeatured(Objects.isNull(dto.getFeatured()) ? member.getFeatured() : dto.getFeatured());
        member.setDisplayOrder(Objects.isNull(dto.getDisplayOrder()) ? member.getDisplayOrder() : dto.getDisplayOrder());
        member.setGithubUrl(Objects.isNull(dto.getGithubUrl()) ? member.getGithubUrl() : dto.getGithubUrl());
        member.setLinkedinUrl(Objects.isNull(dto.getLinkedinUrl()) ? member.getLinkedinUrl() : dto.getLinkedinUrl());
        member.setPersonalWebsite(Objects.isNull(dto.getPersonalWebsite()) ? member.getPersonalWebsite(): dto.getPersonalWebsite());
    }
}