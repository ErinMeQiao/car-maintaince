package com.wyq.hf.service.finance;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Financeinfo;
import com.yinbo.service.EntityManager;

public interface FinanceManager  extends EntityManager<Financeinfo,Integer> {

	public List<Financeinfo> findFinanceList(HttpServletRequest request);
}
