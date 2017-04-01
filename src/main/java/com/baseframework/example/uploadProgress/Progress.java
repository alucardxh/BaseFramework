package com.baseframework.example.uploadProgress;

public class Progress {
	/** 已上传总字节数 */
	private long pBytesRead;
	/** 总文件字节数 */
	private long pContentLength;
	/** 当前文件索引 */
	private int pItems;

	public long getpBytesRead() {
		return pBytesRead;
	}

	public void setpBytesRead(long pBytesRead) {
		this.pBytesRead = pBytesRead;
	}

	public long getpContentLength() {
		return pContentLength;
	}

	public void setpContentLength(long pContentLength) {
		this.pContentLength = pContentLength;
	}

	public int getpItems() {
		return pItems;
	}

	public void setpItems(int pItems) {
		this.pItems = pItems;
	}

	@Override
	public String toString() {
		return "Progress [pBytesRead=" + pBytesRead + ", pContentLength="
				+ pContentLength + ", pItems=" + pItems + "]";
	}

}
