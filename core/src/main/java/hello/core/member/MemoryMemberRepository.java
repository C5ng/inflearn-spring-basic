package hello.core.member;

/* 인터페이스랑 구현체 위치를 같은 패키지 보다 다른 패키지에 두는 것이 설계성이 더 좋다. */

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    /* ConcurrentHashMap 동시성 이슈 */

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
