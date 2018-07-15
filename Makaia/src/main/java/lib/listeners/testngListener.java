package lib.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class testngListener implements IAnnotationTransformer,IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int maxcount=1;
		if(result.isSuccess()& maxcount<2) {
			maxcount++;
			return true;
		}
		return false;
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(this.getClass());
		if(testMethod.getName().equals("createLead")) {
			annotation.setTimeOut(10000);
			annotation.setInvocationCount(2);
		}
		if(testMethod.getName().equals("deleteLead")) {
			annotation.setEnabled(false);
		}
		
	}
	
	

}
