package design.pattern.builder;

public class Department {

    private final int id;
    private final String name;
    private final String description;


    public Department(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;

        public Builder(int id) {
            this.id = id;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
