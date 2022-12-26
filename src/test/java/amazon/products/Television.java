package amazon.products;

import amazon.utils.PropertiesParser;

import java.util.Objects;

public final class Television extends Product {

    // private non-final fields
    private String qty;

    // copy constructor
    private Television(Television television) {
        super(television);
        this.qty = television.qty;
    }

    // no-arg constructor for serialization and builder
    Television() {
    }

    // getter methods
    public final String getQty() {
        return qty;
    }

    // package private setter methods, good for serialization frameworks
    final void setQty(String qty) {
        this.qty = qty;
    }

    // the builder that creates lops
    public static final class Builder extends PBuilder<Television, Builder> {

        public Builder() {
            super(new Television());
        }

        // we could provide a public copy constructor to support modifying lops
        public Builder(Television television) {
            super(new Television(television));
        }

        public final Builder qty(String qty) {
            product.setQty(qty);
            return self();
        }

        public Television build() {
            return new Television(product);
        }
    }

    public static Television getExpectedObject(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new Television.Builder()
                .title(listOfProperties[0])
                .price(listOfProperties[1])
                .qty(listOfProperties[2])
                .build();
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + getTitle() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", size='" + getQty() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television television = (Television) o;
        return Objects.equals(getTitle(), television.getTitle()) && Objects.equals(getPrice(), television.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }
}
