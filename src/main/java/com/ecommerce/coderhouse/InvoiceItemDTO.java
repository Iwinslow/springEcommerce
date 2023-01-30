package com.ecommerce.coderhouse;

public class InvoiceItemDTO {
    
    private Long productid;

    private int quantity;

    public InvoiceItemDTO() {
    }
    
    public Long getProductid() {
        return productid;
    }


    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productid == null) ? 0 : productid.hashCode());
        result = prime * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceItemDTO other = (InvoiceItemDTO) obj;
        if (productid == null) {
            if (other.productid != null)
                return false;
        } else if (!productid.equals(other.productid))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InvoiceItemDTO [productid=" + productid + ", quantity=" + quantity + "]";
    }

    
}
