package by.tc.jwd.task3_3.kizin.entity.model;

public class Project {

    private String productName;
    private int id;
    private String price;


    public Project(){

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product) {
        this.productName = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (productName != null ? !productName.equals(project.productName) : project.productName != null) return false;
        return price != null ? price.equals(project.price) : project.price == null;
    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Project{" +
                "product='" + productName + '\'' +
                ", id=" + id +
                ", price='" + price + '\'' +
                '}';
    }
}
