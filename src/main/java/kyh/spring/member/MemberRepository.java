package kyh.spring.member;

// Mapper
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
