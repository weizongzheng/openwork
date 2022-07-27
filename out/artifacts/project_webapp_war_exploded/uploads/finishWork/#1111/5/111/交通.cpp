#include<iostream>
#include<cmath>
using namespace std;
double Hd,Ld;//��Ч��ƣ���Ч�̵�ʱ��
double T;//ǲɢʱ��
double Tx;//������Ч��ʱ��
double v,s,c;
double CTime;//���̵�����ʱ��
double k;
int flag=1;
/*
57 35
453 1650 92 3
R
13


*/
void Time()//ǲɢʱ��  
{ // v:��ͨ������s����������, c:��ͨ��������
	c=s*k*Ld/CTime;
double y=v/s;
double x=v*k/c;
double Nu,No;
if(x<1)
	Nu=v*k*Hd/3600;
else
	Nu=c*k*Hd/3600;
double x0=0.67+s*Ld*k/(600*3600);//ge:��Ч�̵�=�̵�ʱ��+�Ƶ�ʱ�䣻
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




//��һ�׶θ���
void change1(){

//�̵�ʱ���ӳ�,���̵�ʱ��ΪLd,Th=���˺�ƶ೤ʱ��
//ͨ�����Th��Ҫ�ڼ���һ��������·�ڵ���ʱ��
double dHd=Tx*Hd/(Hd+Ld);
double dLd=Tx*Ld/(Hd+Ld);
cout<<"�ӳ���������,��������"<<endl;
printf("�����Ҫ�ӳ� %.1f �̵���Ҫ�ӳ�%.1f \n ",dHd,dLd);
//���������
cout<<"���������ʱ"<<endl;
double gt;
cout<<"����ߵ�Ԥ��ʱ��"<<endl;
cin>>gt;//����ߵ�
if(gt==CTime/2)
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
else if(gt>CTime/2)
	cout<<"�����Ҫ�ӳ�"<<gt-CTime/2<<"s"<<endl;
else{
	if(CTime/2-gt<Ld-T)
		cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
	else{
	
		cout<<"�����Ҫ����"<<CTime/2-gt-(Ld-T)<<"s"<<endl;
	
	
	}


}
}





//�ڶ��׶θ���
void change2(){
//���ʱ�����̣�����Ч���ʱ��ΪHd��
	if(flag){
double dHd=(Hd+T-Tx)*Hd/(Hd+Ld);
double dLd=(Hd+T-Tx)*Ld/(Hd+Ld);
cout<<"�ӳ���������,��������"<<endl;
printf("�����Ҫ���� %.1f �̵���Ҫ����%.1f \n ",dHd,dLd);
	}
else{
double dHd=(T-Tx)*Hd/(Hd+Ld);
double dLd=(T-Tx)*Ld/(Hd+Ld);
cout<<"�ӳ���������,��������"<<endl;
printf("�����Ҫ���� %.1f �̵���Ҫ����%.1f \n ",dHd,dLd);

}
double gt;
cout<<"���������ʱ"<<endl;
cout<<"����ߵ�Ԥ��ʱ��"<<endl;
cin>>gt;//����ߵ�
if(gt<CTime/2)
	cout<<"�����Ҫ����"<<CTime/2-gt<<"s"<<endl;
else if(gt==CTime/2)
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
else
{
	if(gt-CTime/2<Ld-T)
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
	else
		cout<<"�����Ҫ�ӳ�"<<CTime/2-gt-(Ld-T)<<"s"<<endl;


}
//֮�󷵻غ��ʱ��
}



int main (){

cout<<"������Ч���ʱ������Ч�̵�ʱ��"<<endl;
cin>>Hd>>Ld;

cout<<"���뽻ͨ����������������ԭ����ʱ��,��������"<<endl;
cin>>v>>s>>CTime>>k;
Time();
cout<<"ǲɢʱ��T="<<T<<endl;
cout<<"�����뵱ǰ��ɫ��R��Y��L"<<endl;
char light;
cin>>light;
if(light=='R')
{

double Htime;//���ʱ��
cout<<"�����뾭���������"<<endl;
cin>>Htime;
Tx=Htime-2;
if(Htime-2<=(Hd+T)/2)//�׶�1
	change1();
else //�׶�2
	change2();
}
else if(light=='L')
{
double Htime;
cout<<"�����뾭���̵�����"<<endl;
cin>>Htime;

double newT=Htime-2-T;
if((newT<=0)||(newT>=Ld-T))//�ڶ��׶�
{
	flag=0;
	Tx=Htime-2+Hd;
	change2();
}
else{
	cout<<"��һ���������"<<endl;
	Tx=Htime-2;
	cout<<"���������ʱ"<<endl;
	cout<<"����ߵ�Ԥ��ʱ��"<<endl;
	double gt;
	cin>>gt;//����ߵ�
	if(gt<CTime/2)
	{
		if(CTime/2-gt<Tx-T)
			cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
		else
			printf("�����Ҫ����%.1f s",CTime/2-gt-(Tx-T));
	
	}
	else if(gt==CTime/2)
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
	else
	{
	if(gt-CTime/2>Ld-Tx)
		cout<<"�̵���Ҫ�ӳ�"<<gt-CTime/2-(Ld-Tx)<<"s"<<endl;
	else
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;

		

}

}

}
else
{
	cout<<"��һ���������"<<endl;
	double Htime;
	cout<<"�����뾭���̵�����"<<endl;
	cin>>Htime;
	Tx=Htime-2;
	cout<<"���������ʱ"<<endl;
	cout<<"����ߵ�Ԥ��ʱ��"<<endl;
	double gt;
	cin>>gt;//����ߵ�
	if(gt<CTime/2)
	{
		if(CTime/2-gt<Tx-T)
			cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
		else
	cout<<"�����Ҫ����"<<CTime/2-gt-(Tx-T)<<"s"<<endl;
	}
	else if(gt==CTime/2)
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;
	else
	{
	if(gt-CTime/2>Ld-Tx)
		cout<<"�����Ҫ�ӳ�"<<CTime/2-gt-(Ld-Tx)<<"s"<<endl;
	else
	cout<<"���ÿ���ָ��ʱ�䵽��"<<endl;

		

	}

}




return 0;
}