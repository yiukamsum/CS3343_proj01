package obj;

public class MemberConsole extends UserConsole {

    ////////////////////
    /* Private Method */
    private Member member;

    public MemberConsole() {
        this.member = null;
    }

    public Member getMember() {
        return this.member;
    }

    @Override
    public void start() {
        // ask member to login
        member = (Member) new MemberLogin().login(this);
        // user cancel login, end the console
        if(member == null) { return; }

        /* welcome msg */
        System.out.printf("Welcome %s\n", member.getAccountName());

        /* start the member menu */
        MemberMenuPage memberMenu = new MemberMenuPage(this);
        memberMenu.display();
    }
}
