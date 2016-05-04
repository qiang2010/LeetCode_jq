package qiang.leetcode4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SJF {

	public static void main(String[] args) {
		
		SJF ss = new SJF();
		int []req = {0,1,3,9};
		int []dur = {2,1,7,5};
		System.out.println(ss.sjf(req, dur));
	}
	
	class Job{
		int beginTime;
		int durT ; 
		Job(int b,int d){
			beginTime = b;
			durT = d;
		}
	}
	double  sjf(int[] req,int []dur){
		
		if(req == null || dur == null) return 0;
		int len1 = req.length;
		int len2 = dur.length;
		if(len1 != len2 || len1==0 || len2==0) return 0;
		
		int waitAll = 0;
		Comparator<Job> com = new Comparator<SJF.Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				if(o1.durT < o2.durT) return -1;
				if(o1.durT > o2.durT) return 1;
				if(o1.beginTime < o2.beginTime) return -1;
				return 1;
			}
		};
		PriorityQueue<Job> pro = new PriorityQueue<>(com);
		int curTime =0; //这里所有job的开始时间都是0，如果不是这样，可以修改成第一个job的开始时间
		int i =0;
		while(i < len1){
			// 首先将所有可以运行的job加入到队列中。
			while(i<len1 && req[i]<= curTime){
				pro.add(new Job(req[i], dur[i]));
				i++;
			}
			// 从pro中出一个 需要运行的job
			Job top = pro.poll();
			waitAll += curTime-top.beginTime; // 这里竟然忘记减去了每个任务的起始时间
			curTime += top.durT; 
		}
		// 将队列中的元素都出来
		while(pro.isEmpty()==false){
			Job top = pro.poll();
			waitAll += curTime-top.beginTime;
			curTime += top.durT; 
		}
		return waitAll*1.0/len1;
	}
}
