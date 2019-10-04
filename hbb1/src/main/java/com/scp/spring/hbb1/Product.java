package com.scp.spring.hbb1;

public class Product {

		private int productId;
		private String productName;
		private String productLabel;
		private int productQty;
		private int productPrice;
		@Override
		public String toString() {
			return "\n [productId=" + productId + ", productName=" + productName + ", productLabel=" + productLabel
					+ ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
		}
		public Product(int productId, String productName, String productLabel, int productQty, int productPrice) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productLabel = productLabel;
			this.productQty = productQty;
			this.productPrice = productPrice;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductLabel() {
			return productLabel;
		}
		public void setProductLabel(String productLabel) {
			this.productLabel = productLabel;
		}
		public int getProductQty() {
			return productQty;
		}
		public void setProductQty(int productQty) {
			this.productQty = productQty;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		
		
		
}
