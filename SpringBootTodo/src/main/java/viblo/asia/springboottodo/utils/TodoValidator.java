package viblo.asia.springboottodo.utils;

import org.thymeleaf.util.StringUtils;
import viblo.asia.springboottodo.Entity.Todo;
import java.util.Optional;

/*
Đối tượng này dùng để kiểm tra xem một Object Todo có hợp lệ không
 */
public class TodoValidator {

    /**
     * Kiểm tra một object Todo có hợp lệ không
     * @param todo
     * @return true nếu hợp lệ, false nếu không hợp lệ
     */
    public boolean isValid(Todo todo) {
        return Optional.ofNullable(todo)
                .filter(t -> !StringUtils.isEmpty(t.getTitle())) // Kiểm tra title khác rỗng
                .filter(t -> !StringUtils.isEmpty(t.getDetail())) // Kiểm tra detail khác rỗng
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}

