package argin.io.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author argin
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Family implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证号
     */
    private String card;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String head;

    /**
     * 性别：1男 0女
     */
    private Integer gender;

    /**
     * 第几代
     */
    private Integer generation;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 出生地
     */
    private String birthPlace;

    /**
     * 现居地
     */
    private String currentPlace;

    /**
     * 阳历生日
     */
    private LocalDateTime solarBirthday;

    /**
     * 阴历生日
     */
    private LocalDateTime lunarBirthday;

    /**
     * 爱人
     */
    private Integer lId;

    /**
     * 父亲
     */
    private Integer fId;

    /**
     * 母亲
     */
    private Integer mId;

    /**
     * 爱人父亲
     */
    private Integer lfId;

    /**
     * 爱人母亲
     */
    private Integer lmId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private transient List<Family> children;

    public void now() {
        this.updateTime = LocalDateTime.now();
    }
}
