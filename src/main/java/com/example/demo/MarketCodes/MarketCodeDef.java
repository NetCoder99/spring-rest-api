package com.example.demo.MarketCodes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class MarketCodeDef {
		@Id	@Column int recordId;
		@Column private String marketCd; 
		@Column private String warningNo;

		public MarketCodeDef() {}

		public MarketCodeDef(int recordId, String marketCd, String warningNo) {
			super();
			this.recordId = recordId;
			this.marketCd = marketCd;
			this.warningNo = warningNo;
		}

		public int getRecordId() {
			return recordId;
		}

		public void setRecordId(int recordId) {
			this.recordId = recordId;
		}

		public String getMarketCd() {
			return marketCd;
		}

		public void setMarketCd(String marketCd) {
			this.marketCd = marketCd;
		}

		public String getWarningNo() {
			return warningNo;
		}

		public void setWarningNo(String warningNo) {
			this.warningNo = warningNo;
		}

}
