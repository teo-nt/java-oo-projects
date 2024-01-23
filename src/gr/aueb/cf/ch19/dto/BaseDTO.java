package gr.aueb.cf.ch19.dto;

public abstract class BaseDTO {
    private Long id;

    public BaseDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
