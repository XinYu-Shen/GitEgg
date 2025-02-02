package com.gitegg.service.extension.sms.dto;

import com.gitegg.platform.mybatis.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 短信配置表
 * </p>
 *
 * @author GitEgg
 * @since 2021-01-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SmsTemplate对象", description="短信配置表")
public class UpdateSmsTemplateDTO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "短信渠道id")
    private Long channelId;

    @ApiModelProperty(value = "短信编码")
    private String smsCode;

    @ApiModelProperty(value = "短信名称")
    private String smsName;

    @ApiModelProperty(value = "短信模板ID")
    private String templateId;

    @ApiModelProperty(value = "短信签名")
    private String signName;

    @ApiModelProperty(value = "短信状态 1有效 0禁用")
    private Integer templateStatus;

    @ApiModelProperty(value = "描述")
    private String comments;


}
