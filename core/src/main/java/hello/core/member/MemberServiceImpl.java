package hello.core.member;

//더이상 MemoryMemberRepository 코드가 없음. 즉 추상화에만 의존하도록 변경됨
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; //구체화에 의존하지 않고, 외부(config파일)에서 기획할 수 있도록 인터페이스형만 선언.

    public MemberServiceImpl(MemberRepository memberRepository) { //외부(config)파일에서 구현체 받음
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
