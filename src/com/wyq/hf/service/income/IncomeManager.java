package com.wyq.hf.service.income;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Incomeinfo;
import com.yinbo.service.EntityManager;

public interface IncomeManager  extends EntityManager<Incomeinfo,Integer> {

	public List<Incomeinfo> findIncomeList(HttpServletRequest request);
}
