package amazon.products;

import amazon.utils.PropertiesParser;

import java.util.Objects;

public class Iphone extends Product {
    public Iphone() {}

    private Iphone(IphoneBuilder builder) {
        this.productTitle = builder.productTitle;
        this.actualPrice = builder.actualPrice;
    }

    public static class IphoneBuilder {
        private String productTitle;
        private String actualPrice;

        public IphoneBuilder setIphoneTitle(String productTitle) {
            this.productTitle = productTitle;
            return this;
        }

        public IphoneBuilder setPrice(String actualPrice) {
            this.actualPrice = actualPrice;
            return this;
        }

        public Iphone build() {
            return new Iphone(this);
        }
    }

    public static Iphone getExpectedIphone(String key) {
        PropertiesParser propertiesParser = new PropertiesParser();
        String[] listOfProperties = propertiesParser.parsProperties(key);
        return new IphoneBuilder()
                .setIphoneTitle(listOfProperties[0])
                .setPrice(listOfProperties[1])
                .build();
    }

    @Override
    public String toString() {
        return "Product{" +
                "productTitle='" + productTitle + '\'' +
                ", price='" + actualPrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iphone iPhone = (Iphone) o;
        return Objects.equals(productTitle, iPhone.productTitle) && Objects.equals(actualPrice, iPhone.actualPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTitle, actualPrice);
    }
}
