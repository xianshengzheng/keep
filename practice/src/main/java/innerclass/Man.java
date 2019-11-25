package innerclass;

/**
 * @author Eric
 * @Title: Man
 * @date 2019/8/28 11:40
 * @Description: TODO
 */
class Man{
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }
}
