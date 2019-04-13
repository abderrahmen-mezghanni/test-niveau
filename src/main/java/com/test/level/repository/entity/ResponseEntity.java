package com.test.level.repository.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "response")
public class ResponseEntity  extends AbstractEntity{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "RESPONSE_ID", unique = true, nullable = false)
		private Long id;

		
		@Column(name = "STATEMENT", unique = true, nullable = false, length = 60)
		private String statement;
		
		@Column(name = "VERIFY", nullable = false)
		private String Verify;
		
	

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "QUESTION_ID", nullable = false)
		private QuestionEntity question;

		public ResponseEntity() {
			super();
		}

		public ResponseEntity(Long id, String statement, QuestionEntity question) {
			super();
			this.id = id;
			this.statement = statement;
			this.question = question;
		}
		
		

		public String getVerify() {
			return Verify;
		}

		public void setVerify(String Verify) {
			this.Verify = Verify;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatement() {
			return statement;
		}

		public void setStatement(String statement) {
			this.statement = statement;
		}

		public QuestionEntity getQuestion() {
			return question;
		}

		public void setQuestion(QuestionEntity question) {
			this.question = question;
		}
		
		
}
