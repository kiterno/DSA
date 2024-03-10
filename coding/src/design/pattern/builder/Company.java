package design.pattern.builder;

public class Company {
    private String name;
    private String product;

    private int turnover;

    public Company(Builder builder) {
        this.name = builder.name;
        this.product = builder.product;
        this.turnover = builder.turnover;
    }


    public static class Builder {
        private final String name;
        private final String product;
        private int turnover;

        public Builder(String name, String product) {
            this.name = name;
            this.product = product;
        }

        public Builder setTurnover(int turnover) {
            this.turnover = turnover;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", turnover=" + turnover +
                '}';
    }
}
