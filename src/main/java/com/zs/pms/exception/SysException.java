package com.zs.pms.exception;

public class SysException extends Exception {
	    // 异常码
		private int errCode;
		// 异常信息
		private String errMsg;
		public int getErrCode() {
			return errCode;
		}
		public void setErrCode(int errCode) {
			this.errCode = errCode;
		}
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
		//创建有参构造函数用来给异常信息
		public SysException(int errCode, String errMsg) {
			this.errCode = errCode;
			this.errMsg = errMsg;
		}
		
}
