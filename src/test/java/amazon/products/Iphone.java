package amazon.products;

import amazon.utils.PropertiesParser;

import java.util.Objects;

public final class Iphone extends Product {
    private String size;

    private Iphone(Iphone iphone) {
        super(iphone);
        this.size = iphone.size;
    }

    Iphone() {
    }

    public final String getSize() {
        return size;
    }

    final void setSize(String size) {
        this.size = size;
    }

    public static final class Builder extends PBuilder<Iphone, Builder> {

        public Builder() {
            super(new Iphone());
        }

        public Builder(Iphone iphone) {
            super(new Iphone(iphone));
        }

        public final Builder size(String size) {
            product.setSize(size);
            return self();
        }

        public Iphone build() {
            return new Iphone(product);
        }
    }

    public static Iphone getExpectedObject(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new Iphone.Builder()
                .title(listOfProperties[0])
                .price(listOfProperties[1])
                .size(listOfProperties[2])
                .build();
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + getTitle() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", size='" + getSize() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iphone iPhone = (Iphone) o;
        return Objects.equals(getTitle(), iPhone.getTitle()) && Objects.equals(getPrice(), iPhone.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPrice());
    }
}
