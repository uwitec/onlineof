/*
 * 版权声明：
 * 此文档的版权归常德help信息科技有限公司所有。
 * 未征得常德help信息科技有限公司的书面批准，不得向第三方借阅、出让、出版该文档。
 */
package com.cd_help.onlineOF.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cd_help.onlineOF.api.FoodDataDao;

/**
 * <b><code></code></b>
 * <p/>
 * 酒席数据处理实现类
 * <p/>
 * <b>Creation Time:</b> Jul 4, 2009
 * @author TanDong
 * @version 0.0.0.1
 *
 * @since cd_help-onlineOF 0.0.0.1
 */
@Service("foodDataDao")
@Transactional
@SuppressWarnings("unchecked")
public class FoodDataDaoImpl extends BaseDaoSupport implements FoodDataDao{

}
