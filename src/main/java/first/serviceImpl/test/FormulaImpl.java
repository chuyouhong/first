package first.serviceImpl.test;

import org.springframework.stereotype.Service;

import first.service.test.Formula;
@Service
public class FormulaImpl implements Formula{

	@Override
	public double calculate(int a) {

		return sqrt(a * 100);
	}

}
