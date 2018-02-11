package com.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串匹配Sample
 * <p>
 * 匹配算法:<br>
 * 1. 暴力匹配<br>
 * 2. <a href="http://blog.csdn.net/v_july_v/article/details/7041827">KMP匹配 </a>
 * </br>
 * 3. 改进KMP匹配<br>
 * 
 * @author TianmaF:/excel/a.xlsx
 *
 */
public class Test {
	
	public static void main(String[] args) {
		File file = new File("E://1//demo3.xlsx");  
        ArrayList<ArrayList<Object>> result = ExcelUtil.readExcel(file);  
        ArrayList<Object> colList = null;
        ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
        
        ArrayList<Object> biaoTi= new ArrayList<Object>();
        biaoTi.add("原文");
        biaoTi.add("result");
        biaoTi.add("特征字符仅供参考");
        biaoTi.add("J");
        biaoTi.add("M");
        biaoTi.add("C");
        biaoTi.add("R");
        biaoTi.add("D");
        biaoTi.add("P");
        biaoTi.add("S");
        biaoTi.add("N");
        biaoTi.add("O");
        rowList.add(biaoTi);
        for(int i = 1 ;i < result.size() ;i++){ 
        	colList = new ArrayList<Object>();
        	colList = result.get(i);
        	System.out.println(colList.get(0));
        	String yuan=(String) colList.get(0);
        	ArrayList<Object> resultList=checkRef(yuan);
        	rowList.add(resultList);
        }  
       // rowList.add(colList);
        ExcelUtil.writeExcel(rowList,"E://1//result5.xls");  
	}
	
	public static ArrayList<Object> checkRef(String wenxian){
		ArrayList<Object> resultList=new ArrayList<Object>();
		int jint=0;
		int mint=0;
		int cint=0;
		int rint=0;
		int dint=0;
		int pint=0;
		int sint=0;
		int nint=0;
		int oint=0;
		String guanjianci ="";
		if(wenxian!=null&&wenxian!=""){
			if(wenxian.contains("[J]")||wenxian.contains("［J］")||wenxian.contains("[J/OL]")||wenxian.contains("［J/OL］")){
				jint+=10;
				guanjianci+="[J]-";
			}
			if(wenxian.contains("[M]")||wenxian.contains("［M］")||wenxian.contains("[M/OL]")||wenxian.contains("［M/OL］")){
				mint+=10;
				guanjianci+="[M]-";
			}
			if(wenxian.contains("[C]")||wenxian.contains("［C］")||wenxian.contains("[C/OL]")||wenxian.contains("［C/OL］")){
				cint+=10;
				guanjianci+="[C]-";
			}
			if(wenxian.contains("[R]")||wenxian.contains("［R］")||wenxian.contains("[R/OL]")||wenxian.contains("［R/OL］")){
				rint+=10;
				guanjianci+="[R]-";
			}
			if(wenxian.contains("[D]")||wenxian.contains("［D］")||wenxian.contains("[D/OL]")||wenxian.contains("［D/OL］")){
				dint+=10;
				guanjianci+="[D]-";
			}
			if(wenxian.contains("[P]")||wenxian.contains("［P］")||wenxian.contains("[P/OL]")||wenxian.contains("［P/OL］")){
				pint+=10;
				guanjianci+="[P]-";
			}
			if(wenxian.contains("[S]")||wenxian.contains("［S］")||wenxian.contains("[S/OL]")|wenxian.contains("［S/OL］")){
				sint+=10;
				guanjianci+="[S]-";
			}
			if(wenxian.contains("[N]")||wenxian.contains("［N］")||wenxian.contains("[N/OL]")||wenxian.contains("［N/OL］")){
				nint+=10;
				guanjianci+="[N]-";
			}
			//m开始
			if(wenxian.contains("出版")&&!wenxian.contains("出版社")){
				mint+=20;
				guanjianci+="出版(m)-";
			}
			if(wenxian.contains("出版社")){
				mint+=20;
				guanjianci+="出版社(m)-";
			}
		    Pattern PressP= Pattern.compile("[^a-zA-Z]Press[^a-zA-Z]");
			Matcher  PressM = PressP.matcher(wenxian);
			while (PressM.find()){
				mint+=20;
				guanjianci+="Press(m)-";
			}
			if(wenxian.contains("书局")){
				mint+=20;
				guanjianci+="书局(m)-";
			}
			if(wenxian.contains("书店")){
				mint+=20;
				guanjianci+="书店(m)-";
			}
			if(wenxian.contains("指南")){
				mint+=20;
				guanjianci+="指南(m)-";
			}
			if(wenxian.contains("译.")){
				mint+=20;
				guanjianci+="译.(m)-";
			}
			
			if(wenxian.contains("[著]")||wenxian.contains("［著］")){
				mint+=20;
				guanjianci+="[著](m)-";
			}
			if(wenxian.contains("编著")){
				mint+=20;
				guanjianci+="编著(m)-";
			}
			
			Pattern eddian= Pattern.compile("[^a-zA-Z]ed\\.[^a-zA-Z]");
			Matcher  eddianM = eddian.matcher(wenxian);
			while (eddianM.find()){
				mint+=20;
				guanjianci+="ed.(m)-";
			}
			Pattern Eds= Pattern.compile("[^a-zA-Z]Eds[^a-zA-Z]");
			Matcher  EdsM = Eds.matcher(wenxian);
			while (EdsM.find()){
				mint+=20;
				guanjianci+="Eds(m)-";
			}
			Pattern Edition= Pattern.compile("[^a-zA-Z]Edition[^a-zA-Z]");
			Matcher  EditionM = Edition.matcher(wenxian);
			while (EditionM.find()){
				mint+=20;
				guanjianci+="Edition(m)-";
			}
			
			Pattern Inc= Pattern.compile("[^a-zA-Z]Inc\\.[^a-zA-Z]");
			Matcher  IncM = Inc.matcher(wenxian);
			while (IncM.find()){
				mint+=20;
				guanjianci+="Inc.(m)-";
			}
			Pattern ISBN= Pattern.compile("[^a-zA-Z]ISBN[^a-zA-Z]");
			Matcher  ISBNM = ISBN.matcher(wenxian);
			while (ISBNM.find()){
				mint+=20;
				guanjianci+="ISBN(m)-";
			}
			
			Pattern Elsevier= Pattern.compile("[^a-zA-Z]Elsevier[^a-zA-Z]");
			Matcher  ElsevierM = Elsevier.matcher(wenxian);
			while (ElsevierM.find()){
				mint+=20;
				guanjianci+="Elsevier(m)-";
			}
			Pattern Springer= Pattern.compile("[^a-zA-Z]Springer[^a-zA-Z]");
			Matcher  SpringerM = Springer.matcher(wenxian);
			while (SpringerM.find()){
				mint+=20;
				guanjianci+="Springer(m)-";
			}
			Pattern Verlag= Pattern.compile("[^a-zA-Z]Verlag[^a-zA-Z]");
			Matcher  VerlagM = Verlag.matcher(wenxian);
			while (VerlagM.find()){
				mint+=20;
				guanjianci+="Verlag(m)-";
			}
			Pattern PublishingHouse= Pattern.compile("[^a-zA-Z]Publishing House[^a-zA-Z]");
			Matcher  PublishingHousem = PublishingHouse.matcher(wenxian);
			while (PublishingHousem.find()){
				mint+=20;
				guanjianci+="Publishing House(m)-";
			}
			Pattern john= Pattern.compile("[^a-zA-Z]John Wiley \\& Sons[^a-zA-Z]");
			Matcher  johnM = john.matcher(wenxian);
			while (johnM.find()){
				mint+=20;
				guanjianci+="John Wiley & Sons(m)-";
			}
			Pattern john2= Pattern.compile("[^a-zA-Z]John Wiley and Sons[^a-zA-Z]");
			Matcher  johnM2 = john2.matcher(wenxian);
			while (johnM2.find()){
				mint+=20;
				guanjianci+="John Wiley and Sons(m)-";
			}
			Pattern Boston= Pattern.compile("[^a-zA-Z]Boston[^a-zA-Z]");
			Matcher  BostonM = Boston.matcher(wenxian);
			while (BostonM.find()){
				mint+=20;
				guanjianci+="Boston(m)-";
			}
			
			Pattern NewYork= Pattern.compile("[^a-zA-Z]New York[^a-zA-Z]");
			Matcher  NewYorkm = NewYork.matcher(wenxian);
			while (NewYorkm.find()){
				mint+=20;
				guanjianci+="New York(m)-";
			}
				
			Pattern Handbook= Pattern.compile("[^a-zA-Z]Handbook[^a-zA-Z]");
			Matcher  HandbookM = Handbook.matcher(wenxian);
			while (HandbookM.find()){
				mint+=20;
				guanjianci+="Handbook(m)-";
			}
			Pattern Publishing= Pattern.compile("[^a-zA-Z]Publishing[^a-zA-Z]");
			Matcher  PublishingM = Publishing.matcher(wenxian);
			while (PublishingM.find()){
				mint+=20;
				guanjianci+="Publishing(m)-";
			}
			Pattern WashingtonDC= Pattern.compile("[^a-zA-Z]Washington DC[^a-zA-Z]");
			Matcher  WashingtonDCM = WashingtonDC.matcher(wenxian);
			while (WashingtonDCM.find()){
				mint+=20;
				guanjianci+="Washington DC(m)-";
			}
			if(mint<20){
				jint+=1;
			}
			//m结束
			//c开始
			if(wenxian.contains("论文集")){
				cint+=20;
				guanjianci+="论文集(c)-";
			}
			
			Pattern Proceedings= Pattern.compile("[^a-zA-Z]Proceedings[^a-zA-Z]");
			Matcher  ProceedingsM = Proceedings.matcher(wenxian);
			while (ProceedingsM.find()){
				cint+=20;
				guanjianci+="Proceedings(c)-";
			}
			Pattern Symposium= Pattern.compile("[^a-zA-Z]Symposium[^a-zA-Z]");
			Matcher  SymposiumM = Symposium.matcher(wenxian);
			while (SymposiumM.find()){
				cint+=20;
				guanjianci+="Symposium(c)-";
			}
			Pattern Conference= Pattern.compile("[^a-zA-Z]Conference[^a-zA-Z]");
			Matcher  ConferenceM = Conference.matcher(wenxian);
			while (ConferenceM.find()){
				cint+=20;
				guanjianci+="Conference(c)-";
			}
			Pattern Meeting= Pattern.compile("[^a-zA-Z]Meeting[^a-zA-Z]");
			Matcher  Meetingm = Meeting.matcher(wenxian);
			while (Meetingm.find()){
				cint+=20;
				guanjianci+="Meeting(c)-";
			}
			Pattern Congress= Pattern.compile("[^a-zA-Z]Congress[^a-zA-Z]");
			Matcher  CongressM = Congress.matcher(wenxian);
			while (CongressM.find()){
				cint+=20;
				guanjianci+="Congress(c)-";
			}
			if(wenxian.contains("研讨会")){
				cint+=20;
				guanjianci+="研讨会(c)-";
			}
			Pattern Workshop= Pattern.compile("[^a-zA-Z]Workshop[^a-zA-Z]");
			Matcher  Workshopm = Workshop.matcher(wenxian);
			while (Workshopm.find()){
				cint+=20;
				guanjianci+="Workshop(c)-";
			}
			
			if(wenxian.contains("会议")){
				cint+=20;
				guanjianci+="会议(c)-";
			}
			if(wenxian.contains("届")){
				cint+=20;
				guanjianci+="届(c)-";
			}
			Pattern  Proc= Pattern.compile("[^a-zA-Z]Proc\\.[^a-zA-Z]");
			Matcher  ProcM = Proc.matcher(wenxian);
			while (ProcM.find()){
				cint+=20;
				guanjianci+="Proc.(c)-";
			}
			if(cint<20){
				jint+=1;
			}
			//c结束
			//r开始
			if(wenxian.contains("白皮书")){
				rint+=20;
				guanjianci+="白皮书(r)-";
			}
			if(wenxian.contains("报告")){
				rint+=20;
				guanjianci+="报告(r)-";
			}
			if(wenxian.contains("大会")){
				rint+=20;
				guanjianci+="大会(r)-";
			}
			if(wenxian.contains("分会")){
				rint+=20;
				guanjianci+="分会(r)-";
			}
			if(wenxian.contains("专题")){
				rint+=20;
				guanjianci+="专题(r)-";
			}
			if(wenxian.contains("特邀")){
				rint+=20;
				guanjianci+="特邀(r)-";
			}
			if(wenxian.contains("年会")){
				rint+=20;
				guanjianci+="年会(r)-";
			}
			if(wenxian.contains("研讨会")){
				rint+=20;
				guanjianci+="研讨会(r)-";
			}
			if(wenxian.contains("论坛")){
				rint+=20;
				guanjianci+="论坛(r)-";
			}
			if(wenxian.contains("建议")){
				rint+=20;
				guanjianci+="建议(r)-";
			}
			Pattern  report= Pattern.compile("[^a-zA-Z]report[^a-zA-Z]");
			Matcher  reportM = report.matcher(wenxian);
			while (reportM.find()){
				rint+=20;
				guanjianci+="report(r)-";
			}
			
			if(wenxian.contains("年鉴")){
				rint+=20;
				guanjianci+="年鉴(r)-";
			}
			Pattern  Catalogue= Pattern.compile("[^a-zA-Z]Catalogue[^a-zA-Z]");
			Matcher  Cataloguem = Catalogue.matcher(wenxian);
			while (Cataloguem.find()){
				rint+=20;
				guanjianci+="Catalogue(r)-";
			}
			Pattern  Statistics= Pattern.compile("[^a-zA-Z]Statistics[^a-zA-Z]");
			Matcher  StatisticsM = Statistics.matcher(wenxian);
			while (StatisticsM.find()){
				rint+=20;
				guanjianci+="Statistics(r)-";
			}
			Pattern  Lecture= Pattern.compile("[^a-zA-Z]Lecture[^a-zA-Z]");
			Matcher  Lecturem = Lecture.matcher(wenxian);
			while (Lecturem.find()){
				rint+=20;
				guanjianci+="Lecture(r)-";
			}
			if(rint<20){
				jint+=1;
			}
			//r结束
			//d开始
			if(wenxian.contains("学位论文")){
				dint+=20;
				guanjianci+="学位论文(d)-";
			}
			Pattern  thesis= Pattern.compile("[^a-zA-Z]thesis[^a-zA-Z]");
			Matcher  thesisM = thesis.matcher(wenxian);
			while (thesisM.find()){
				dint+=20;
				guanjianci+="thesis(d)-";
			}
			if(wenxian.contains("博士论文")){
				dint+=20;
				guanjianci+="博士论文(d)-";
			}
			if(wenxian.contains("硕士")){
				dint+=20;
				guanjianci+="硕士(d)-";
			}
			Pattern  Dissertation= Pattern.compile("[^a-zA-Z]Dissertation[^a-zA-Z]");
			Matcher  Dissertationm = Dissertation.matcher(wenxian);
			while (Dissertationm.find()){
				dint+=20;
				guanjianci+="Dissertation(d)-";
			}
			Pattern  PhD= Pattern.compile("[^a-zA-Z]Ph\\. D\\.[^a-zA-Z]");
			Matcher  PhDm = PhD.matcher(wenxian);
			while (PhDm.find()){
				dint+=20;
				guanjianci+="Ph. D.(d)-";
			}
			if(dint<20){
				jint+=1;
			}
			//d结束
			//p开始
			if(wenxian.contains("专利")){
				pint+=20;
				guanjianci+="专利(p)-";
			}
			Pattern  Patent= Pattern.compile("[^a-zA-Z]Patent[^a-zA-Z]");
			Matcher  PatentM = Patent.matcher(wenxian);
			while (PatentM.find()){
				pint+=20;
				guanjianci+="Patent(p)-";
			}
			Pattern  EP= Pattern.compile("[^a-zA-Z]EP[^a-zA-Z]");
			Matcher  EPm = EP.matcher(wenxian);
			while (EPm.find()){
				pint+=20;
				guanjianci+="EP(p)-";
			}
			if(pint<20){
				jint+=1;
			}
			//p结束
			//s开始
			if(wenxian.contains("标准")){
				sint+=20;
				guanjianci+="标准(s)-";
			}
			Pattern  GB = Pattern.compile("[^a-zA-Z]GB[^a-zA-Z]");
			Matcher  GBm  = GB.matcher(wenxian);
			while (GBm.find()){
				sint+=20;
				guanjianci+="GB(s)-";
			}
			
			Pattern  GBGang = Pattern.compile("[^a-zA-Z]GB/[^a-zA-Z]");
			Matcher  GBGangM  = GBGang.matcher(wenxian);
			while (GBGangM.find()){
				sint+=20;
				guanjianci+="GB/(s)-";
			}
			
			Pattern  GYGang = Pattern.compile("[^a-zA-Z]GY/[^a-zA-Z]");
			Matcher  GYGangM  = GYGang.matcher(wenxian);
			while (GYGangM.find()){
				sint+=20;
				guanjianci+="GY/(s)-";
			}

			Pattern  ISO = Pattern.compile("[^a-zA-Z]ISO[^a-zA-Z]");
			Matcher  ISOm  = ISO.matcher(wenxian);
			while (ISOm.find()){
				sint+=20;
				guanjianci+="ISO(s)-";
			}
			Pattern  NISO = Pattern.compile("[^a-zA-Z]NISO[^a-zA-Z]");
			Matcher  NISOm  = NISO.matcher(wenxian);
			while (NISOm.find()){
				sint+=20;
				guanjianci+="NISO(s)-";
			}
			
			Pattern  W3C = Pattern.compile("[^a-zA-Z]W3C[^a-zA-Z]");
			Matcher  W3CM  = W3C.matcher(wenxian);
			while (W3CM.find()){
				sint+=20;
				guanjianci+="W3C(s)-";
			}
			if(sint<20){
				jint+=1;
			}
			//s结束
			//n开始
			if(wenxian.contains("日报")){
				nint+=20;
				guanjianci+="日报(n)-";
			}
			if(wenxian.contains("早报")){
				nint+=20;
				guanjianci+="早报(n)-";
			}
			if(wenxian.contains("晚报")){
				nint+=20;
				guanjianci+="晚报(n)-";
			}
			if(wenxian.contains("时报")){
				nint+=20;
				guanjianci+="时报(n)-";
			}
			if(wenxian.contains("周报")){
				nint+=20;
				guanjianci+="周报(n)-";
			}
			if(wenxian.contains("画报")){
				nint+=20;
				guanjianci+="画报(n)-";
			}
			
			Pattern  newyorkTime = Pattern.compile("[^a-zA-Z]New York Times[^a-zA-Z]");
			Matcher  newyorkTimeM  = newyorkTime.matcher(wenxian);
			while (newyorkTimeM.find()){
				nint+=20;
				guanjianci+="New York Times(n)-";
			}
			if(nint<20){
				jint+=1;
			}
			//n结束
			//o开始
			
			Pattern  Retrieved = Pattern.compile("[^a-zA-Z]Retrieved[^a-zA-Z]");
			Matcher  RetrievedM  = Retrieved.matcher(wenxian);
			while (RetrievedM.find()){
				oint+=20;
				guanjianci+="Retrieved(ol)-";
			}
			Pattern  EB = Pattern.compile("[^a-zA-Z]EB[^a-zA-Z]");
			Matcher  EBM  = EB.matcher(wenxian);
			while (EBM.find()){
				oint+=20;
				guanjianci+="EB(ol)-";
			}
			Pattern  DB = Pattern.compile("[^a-zA-Z]DB[^a-zA-Z]");
			Matcher  DBm  = DB.matcher(wenxian);
			while (DBm.find()){
				oint+=20;
				guanjianci+="DB(ol)-";
			}
			Pattern  database = Pattern.compile("[^a-zA-Z]database[^a-zA-Z]");
			Matcher  databaseM  = database.matcher(wenxian);
			while (databaseM.find()){
				oint+=20;
				guanjianci+="database(ol)-";
			}
			
			Pattern  Available = Pattern.compile("[^a-zA-Z]Available:[^a-zA-Z]");
			Matcher  AvailableM  = Available.matcher(wenxian);
			while (AvailableM.find()){
				oint+=20;
				guanjianci+="Available:(ol)-";
			}
			Pattern  Available2 = Pattern.compile("[^a-zA-Z]Available：[^a-zA-Z]");
			Matcher  AvailableM2  = Available2.matcher(wenxian);
			while (AvailableM2.find()){
				oint+=20;
				guanjianci+="Available：(ol)-";
			}
			if(oint<20){
				jint+=1;
			}
			//o结束
			//j开始
			if(wenxian.contains("学报")){
				jint+=20;
				guanjianci+="学报(j)-";
			}
			Pattern  Journal = Pattern.compile("[^a-zA-Z]Journal[^a-zA-Z]");
			Matcher  Journalm  = Journal.matcher(wenxian);
			while (Journalm.find()){
				guanjianci+="Journal(j)-";

				jint+=20;
			}
			if(wenxian.contains("杂志")){
				jint+=20;
				guanjianci+="杂志(j)-";

			}
			Pattern  Acta = Pattern.compile("[^a-zA-Z]Acta[^a-zA-Z]");
			Matcher  Actam  = Acta.matcher(wenxian);
			while (Actam.find()){
				jint+=20;
				guanjianci+="Acta(j)-";

			}
			if(wenxian.contains("导刊")){
				jint+=20;
				guanjianci+="导刊(j)-";

			}
			if(wenxian.contains("导报")){
				jint+=20;
				guanjianci+="导报(j)-";

			}
			if(wenxian.contains("通报")){
				jint+=20;
				guanjianci+="通报(j)-";
			}
			Pattern  Quarterly = Pattern.compile("[^a-zA-Z]Quarterly[^a-zA-Z]");
			Matcher  QuarterlyM  = Quarterly.matcher(wenxian);
			while (QuarterlyM.find()){
				jint+=20;
				guanjianci+="Quarterly(j)-";

			}	
			Pattern  Proceedings2 = Pattern.compile("[^a-zA-Z]Proceedings[^a-zA-Z]");
			Matcher  Proceedingsm2  = Proceedings2.matcher(wenxian);
			while (Proceedingsm2.find()){
				jint+=20;
				guanjianci+="Proceedings(j)-";

			}	
			Pattern  IntEd = Pattern.compile("[^a-zA-Z]Int\\. Ed\\.[^a-zA-Z]");
			Matcher  IntEdM  = IntEd.matcher(wenxian);
			while (IntEdM.find()){
				jint+=20;
				guanjianci+="Int. Ed.(j)-";
			}
			//j结束
		
		
		resultList.add(wenxian);
		int result=0;
		String resultString="";
		if(jint>mint){
			result=jint;
		}else{
			result=mint;
		}
		if(result<cint){
			result=cint;
		}
		if(result<rint){
			result=rint;
		}
		if(result<dint){
			result=dint;
		}
		if(result<pint){
			result=pint;
		}
		if(result<sint){
			result=sint;
		}
		if(result<nint){
			result=nint;
		}
		if(result<oint){
			result=oint;
		}
		// 数值相等时 取前面的    M(图书)	C(会议论文) R(报告) D(学位论文)P(专利文献) S(标准文献) J(期刊文献)N(报纸文献)OL(电子资源)
		if(result==0){
			resultString="识别异常";
		}else if (result==mint){
			resultString="M";
		}else if (result==cint){
			resultString="C";
		}else if (result==rint){
			resultString="R";
		}else if (result==dint){
			resultString="D";
		}else if (result==pint){
			resultString="P";
		}else if (result==sint){
			resultString="S";
		}else if (result==jint){
			resultString="J";
		}else if (result==nint){
			resultString="N";
		}else if (result==oint){
			resultString="OL";
		}
		
		
		
		
		resultList.add(resultString);
		resultList.add(guanjianci);
		resultList.add(jint);
		resultList.add(mint);
		resultList.add(cint);
		resultList.add(rint);
		resultList.add(dint);
		resultList.add(pint);
		resultList.add(sint);
		resultList.add(nint);
		resultList.add(oint);
		}
		return resultList;
		
	}
	
}