package pojo;

public class Products {
        private String product;
        private double dollarPrice;
        private double poundsPrice;
        private double euroPrice;


        public Products (String _product,  double _dollarPrice, double _poundsPrice, double _euroPrice){
                this.product = _product;
                this.dollarPrice = _dollarPrice;
                this.poundsPrice = _poundsPrice;
                this.euroPrice = _euroPrice;
        }
        public String getProduct() {
                return this.product;
        }

        public void setProduct(String product) {
                this.product = product;
        }

        public double getDollarPrice() {
                return dollarPrice;
        }
        public void setDollarPrice(double dollarPrice) {
                this.dollarPrice = dollarPrice;
        }

        public double getPoundsPrice() {
                return poundsPrice;
        }
        public void setPoundsPrice(double poundsPrice) {
                this.poundsPrice = poundsPrice;
        }
        public double getEuroPrice() {
                return euroPrice;
        }
        public void setEuroPrice(double euroPrice) {
                this.euroPrice = euroPrice;
        }

}
