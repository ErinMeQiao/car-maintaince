package com.wyq.hf.service.payout;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.wyq.hf.po.Payoutinfo;
import com.yinbo.service.EntityManager;

public interface PayoutManager  extends EntityManager<Payoutinfo,Integer> {

	public List<Payoutinfo> findPayoutinfoList(HttpServletRequest request);
}
