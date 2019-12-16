package com.wyy.common_p2p.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 这是对查询分页条件的分装的
 *
 * LinkedHashMap ==> query == Map
 *
 *
 * query 前台的分页参数
 *       前台的查询参数  name=zhangs age =19
 *
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 页数据
	private int page;
	// 每页条数
	private int rows;
	//总行数
	private long total;

	public Query(Map<String, Object> params) {
		this.putAll(params);
		if(params.get("page") != null){
			// 分页参数
			this.page = Integer.parseInt(params.get("page").toString());
		}else{
			this.page = 1;
		}
		if(params.get("rows") != null){
			// 分页参数
			this.rows = Integer.parseInt(params.get("rows").toString());
		}else{
			this.rows = 1;
		}
	}


	public Query(){
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
