package com.micol.demo;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO{
	//검색에 사용 되는 보
		Integer first;
		Integer last;
		String keyword;
}
