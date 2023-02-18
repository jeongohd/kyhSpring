package kyh.spring.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


// DB역할
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 설계시 데이터베이스가 아직 정해지지 않아서 이렇게라도 개발.

    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 이슈가 발생할 수 있어 ConcurrentHashMap을 사용.

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }


}
