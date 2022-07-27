#include<iostream>
#include<cmath>
using namespace std;
double Hd,Ld;//有效红灯，有效绿灯时长
double T;//遣散时间
double Tx;//经过有效灯时长
double v,s,c;
double CTime;//红绿灯周期时长
double k;
int flag=1;
/*
57 35
453 1650 92 3
R
13


*/
void Time()//遣散时间  
{ // v:交通流量，s：饱和流量, c:交通运行能力
	c=s*k*Ld/CTime;
double y=v/s;
double x=v*k/c;
double Nu,No;
if(x<1)
	Nu=v*k*Hd/3600;
else
	Nu=c*k*Hd/3600;
double x0=0.67+s*Ld*k/(600*3600);//ge:有效绿灯=绿灯时间+黄灯时间；
double Z=x-1;
if(x>x0)
	No=c*CTime/4*(Z+sqrt(Z*Z+12*(x-x0)/CTime/c));
else 
	No=0;
//cout<<"x0="<<x0<<endl;
double Nm=Nu/(1-y)+No;
double N=Nu+No;
double Nb=N*2*v/3600;
double F=v/3600*Nb*0.5;
double n=Nm+F;
//cout<<"NM="<<Nm<<endl;
T=2+n*3600/s/k;

}




//第一阶段更改
void change1(){

//绿灯时间延长,设绿灯时间为Ld,Th=过了红灯多长时间
//通常这个Th需要在加上一个车经过路口的总时间
double dHd=Tx*Hd/(Hd+Ld);
double dLd=Tx*Ld/(Hd+Ld);
cout<<"延长整体周期,方案如下"<<endl;
printf("红灯需要延长 %.1f 绿灯需要延长%.1f \n ",dHd,dLd);
//检查半个周期
cout<<"检查半个周期时"<<endl;
double gt;
cout<<"输入高德预计时间"<<endl;
cin>>gt;//输入高德
if(gt==CTime/2)
	cout<<"正好可在指定时间到达"<<endl;
else if(gt>CTime/2)
	cout<<"红灯需要延长"<<gt-CTime/2<<"s"<<endl;
else{
	if(CTime/2-gt<Ld-T)
		cout<<"正好可在指定时间到达"<<endl;
	else{
	
		cout<<"红灯需要缩短"<<CTime/2-gt-(Ld-T)<<"s"<<endl;
	
	
	}


}
}





//第二阶段更改
void change2(){
//红灯时间缩短，设有效红灯时间为Hd，
	if(flag){
double dHd=(Hd+T-Tx)*Hd/(Hd+Ld);
double dLd=(Hd+T-Tx)*Ld/(Hd+Ld);
cout<<"延长整体周期,方案如下"<<endl;
printf("红灯需要缩短 %.1f 绿灯需要缩短%.1f \n ",dHd,dLd);
	}
else{
double dHd=(T-Tx)*Hd/(Hd+Ld);
double dLd=(T-Tx)*Ld/(Hd+Ld);
cout<<"延长整体周期,方案如下"<<endl;
printf("红灯需要缩短 %.1f 绿灯需要缩短%.1f \n ",dHd,dLd);

}
double gt;
cout<<"检查半个周期时"<<endl;
cout<<"输入高德预计时间"<<endl;
cin>>gt;//输入高德
if(gt<CTime/2)
	cout<<"红灯需要缩短"<<CTime/2-gt<<"s"<<endl;
else if(gt==CTime/2)
	cout<<"正好可在指定时间到达"<<endl;
else
{
	if(gt-CTime/2<Ld-T)
	cout<<"正好可在指定时间到达"<<endl;
	else
		cout<<"红灯需要延长"<<CTime/2-gt-(Ld-T)<<"s"<<endl;


}
//之后返回红灯时长
}



int main (){

cout<<"输入有效红灯时长和有效绿灯时长"<<endl;
cin>>Hd>>Ld;

cout<<"输入交通流量，饱和流量，原周期时长,车道数量"<<endl;
cin>>v>>s>>CTime>>k;
Time();
cout<<"遣散时间T="<<T<<endl;
cout<<"请输入当前灯色：R、Y、L"<<endl;
char light;
cin>>light;
if(light=='R')
{

double Htime;//红灯时长
cout<<"请输入经过红灯秒数"<<endl;
cin>>Htime;
Tx=Htime-2;
if(Htime-2<=(Hd+T)/2)//阶段1
	change1();
else //阶段2
	change2();
}
else if(light=='L')
{
double Htime;
cout<<"请输入经过绿灯秒数"<<endl;
cin>>Htime;

double newT=Htime-2-T;
if((newT<=0)||(newT>=Ld-T))//第二阶段
{
	flag=0;
	Tx=Htime-2+Hd;
	change2();
}
else{
	cout<<"第一次无须调节"<<endl;
	Tx=Htime-2;
	cout<<"检查半个周期时"<<endl;
	cout<<"输入高德预计时间"<<endl;
	double gt;
	cin>>gt;//输入高德
	if(gt<CTime/2)
	{
		if(CTime/2-gt<Tx-T)
			cout<<"正好可在指定时间到达"<<endl;
		else
			printf("红灯需要缩短%.1f s",CTime/2-gt-(Tx-T));
	
	}
	else if(gt==CTime/2)
	cout<<"正好可在指定时间到达"<<endl;
	else
	{
	if(gt-CTime/2>Ld-Tx)
		cout<<"绿灯需要延长"<<gt-CTime/2-(Ld-Tx)<<"s"<<endl;
	else
	cout<<"正好可在指定时间到达"<<endl;

		

}

}

}
else
{
	cout<<"第一次无须调节"<<endl;
	double Htime;
	cout<<"请输入经过绿灯秒数"<<endl;
	cin>>Htime;
	Tx=Htime-2;
	cout<<"检查半个周期时"<<endl;
	cout<<"输入高德预计时间"<<endl;
	double gt;
	cin>>gt;//输入高德
	if(gt<CTime/2)
	{
		if(CTime/2-gt<Tx-T)
			cout<<"正好可在指定时间到达"<<endl;
		else
	cout<<"红灯需要缩短"<<CTime/2-gt-(Tx-T)<<"s"<<endl;
	}
	else if(gt==CTime/2)
	cout<<"正好可在指定时间到达"<<endl;
	else
	{
	if(gt-CTime/2>Ld-Tx)
		cout<<"红灯需要延长"<<CTime/2-gt-(Ld-Tx)<<"s"<<endl;
	else
	cout<<"正好可在指定时间到达"<<endl;

		

	}

}




return 0;
}