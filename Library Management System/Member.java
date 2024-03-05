
public class Member {

    private Integer member_id;
    private String member_name;
    private String DOJ;

    public Member(){

    }
    public Member (Integer member_id, String member_name, String DOJ) {
        this.member_id = member_id;
        this.member_name = member_name;
        this.DOJ = DOJ;
    }

    public Integer getMember_id () {
        return member_id;
    }

    public void setMember_id (Integer member_id) {
        this.member_id = member_id;
    }

    public String getMember_name () {
        return member_name;
    }

    public void setMember_name (String member_name) {
        this.member_name = member_name;
    }

    public String getDOJ () {
        return DOJ;
    }

    public void setDOJ (String DOJ) {
        this.DOJ = DOJ;
    }
}
