package com.ims.mediaservice.hardware.processor;

/**
 * @author Valery Kantor
 *         mailto: valery.kantor@gmail.com
 */
public class CentralProcessor implements Processor {

    private String vendor;
    private String indentifier;
    private String name;

    private CentralProcessor() {
    }

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public String getIdentifier() {
        return indentifier;
    }

    @Override
    public String getName() {
        return name;
    }

    public static class Builder {
        private CentralProcessor product = new CentralProcessor();

        public Builder setVendor(String vendor) {
            this.product.vendor = vendor;
            return this;
        }

        public Builder setIdentifier(String identifier) {
            this.product.indentifier = identifier;
            return this;
        }

        public Builder setName(String name) {
            this.product.name = name;
            return this;
        }

        public CentralProcessor build() {
            return product;
        }
    }
}
