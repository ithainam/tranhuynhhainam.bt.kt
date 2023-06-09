package tranhuynhhainam.bt.kt.entity;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PHONG_BAN")
public class phongban {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 2, max = 2, message = "Phải nhập vào 2 ký tự chữ viết tắt")
    private String maphong;

    @Length(min = 2, max = 30, message = "Phải nhập vào tên phòng")
    private String tenphong;

    public phongban(){}

    public phongban(String maphong, String tenphong) {
        this.maphong = maphong;
        this.tenphong = tenphong;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    @Override
    public String toString() {
        return "phongban{" +
                "maphong='" + maphong + '\'' +
                ", tenphong='" + tenphong + '\'' +
                '}';
    }

    public List<nhanvien> getListNhanviens() {
		return listNhanviens;
	}

	public void setListNhanviens(List<nhanvien> listNhanviens) {
		this.listNhanviens = listNhanviens;
	}

	@OneToMany(mappedBy = "phongban", fetch = FetchType.LAZY)
    private List<nhanvien> listNhanviens;
}