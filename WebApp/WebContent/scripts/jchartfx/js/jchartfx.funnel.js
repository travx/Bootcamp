(function(){var z={Version:"7.1.5021.16204"};window.cfx.Funnel=z;var s=window.cfx,f=window.sfx,t=function A(){A._ic();this.b=this.c=0};t.prototype={_0dM:function(j,c){j.x==c.x?(this.b=j.x,this.c=f.D.d):(this.b=(c.y-j.y)/(c.x-j.x),this.c=c.y-this.b*c.x);return this},a:function(j){return 0==this.b?0:f.D.g(this.c)?this.b:(j-this.c)/this.b}};t._dt("CWGF",f.Sy,0);var j=function c(){c._ic();this.q=null;this.v=!1;this.g=this.h=this.b=null;this.a=this.t=this.e=this.f=0;this._0Funnel()};z.Funnel=j;j.prototype=
{_0Funnel:function(){this.p=4;this.c=5;this.k=30;this.n=10;this.d=this.u=!0;this.o=this.l=!1;this.m=(new s.Line)._01Line(9);return this},getConic:function(){return this.v},setConic:function(c){this.v=c;this.i()},getFaces:function(){return this.p},setFaces:function(c){this.p=f.a.n(c,3);this.i()},getLabelInside:function(){return this.l},setLabelInside:function(c){this.l=c;this.i()},getLabelLine:function(){return this.m},getLabelLineAsSeries:function(){return this.o},setLabelLineAsSeries:function(c){this.o=
c;this.i()},getSeparation:function(){return this.c},setSeparation:function(c){this.c=c;this.i()},getTemplate:function(){return null==this.b?"":this.b.u()},setTemplate:function(c){null==c?this.b=null:(null==this.b&&(this.b=(new _Zt)._0_Zt()),this.b.su(c))},getTipHeight:function(){return this.k},setTipHeight:function(c){this.k=c},getTipWidth:function(){return this.n},setTipWidth:function(c){this.n=c},E:function(){},reset:function(){},icV:function(){return 1},icW:function(){return 142606593},ieG:function(c){this.q=
c;this.m.ieG(this.q)},icU:function(c,b,a){switch(b){case 4:return 1;case 11:return this.y(a);case 12:return!0}return null},icX:function(c,b,a){c.a=1;c.b=0;var h=a.g(256);h&&(a.a$=!0);c=a.a.b.iaH();b=a.v._nc();b.w-=a.a.p;b.y+=a.a.p;b.h-=a.a.p;if(a.b.a.b&&!this.l){for(var g=0,d=0;d<c;d++){a.G=a.ad.getItem(a.d,d);var j=a.by(),j=a.c.idV(j,a.ah).w,g=f.a.n(g,j)}g+=8;2!=a.b.a.h&&(b.x+=g);b.w-=g}var g=b.h,j=b.w,m=(g-this.c*(c-1))*b.w/2,n=g/j,e=983040|a.b.n,i=!1;h?i=!0:(e|=134217728,i=!1);0!=this.c&&(e|=3145728);
var k=0,p=0,r=0,d=0;this.d?(k=-g,p=-1,r=b.c(),d=b.y):(k=g,p=1,r=b.y,d=b.c());var l=new s.ba,q=new s.ba;l.b=b.x;l.a=d+p*this.c;l.c=0;q.b=b.g();q.a=r-p*this.c;q.c=a.a.f;var B=f.u.z(b.g()+b.x,2);this.d&&90<a.f.ib4()||!this.d&&90>=a.f.ib4()?(a.A=-1,a.m=c-1,a.e=a.m,a.o=0):(a.A=1,a.m=0,a.e=a.m,a.o=c-1);var h=h?this.p:4,o=0,v=0,u=a.J,t=a.P;if(t){for(d=u=0;d<c;d++)a.ao(a.d,d,!1),o=a.ad.getItem(a.d,d)*a.aU,u+=o;if(0==u)return}a.bs=u;this.D(a,b);for(d=a.bi=0;d<c;d++){a.aw();if(t){if(0==a.aU){a.an(0,1);continue}a.G*=
a.aU;v+=a.G}else v=a.Q;a.a2=v;if(0!=a.G&&1.0E108!=a.G){0>a.A?(this.u?o=g-v/u*g:(o=m-v*m/u,o=f.a.r(f.a.d(2*o*n))),q.a=l.a-p*this.c,l.a=r+p*o):(this.u?o=v/u*g:(o=v*m/u,o=f.a.r(f.a.d(2*o*n))),l.a=q.a+p*this.c,q.a=r+p*o);var o=this.d?b.y-q.a:b.c()-q.a,x=0;a.g(33554432)&&(x|=1);a.ao(a.d,a.e,!1);a.N(!0);a.ax(a.d,a.e);var y=e;d==c-1&&(y|=3145728);i?this.v?a.f.ib8(a.c,l,q,a.x,a.n,null,y,x,k,o):a.f.icj(a.c,l,q,a.x,a.n,null,y,x,k,o,h):this.A(a.c,l._nc(),q._nc(),x,k,o,a);o=a.G/u;a.b.a.b&&this.B(a,j,g,l,q,B,
r,o,b);a.bi=v}a.an(0,1)}this.E(a,b);a.ak-=c-1;a.e=a.o;null!=this.b&&this.b._dispose1(!1)},D:function(c,b){var a=f.u.z(b.x+b.g(),2),h=this.n*b.w/100;this.f=a-h/2;this.e=a+h/2;a=b.h-this.c*(c.a.b.iaH()-1);this.a=b.c()-a*this.k/100;this.t=c.bs*this.k/100;a=this.d?b.y:b.c();this.h=(new t)._0dM((new f.e)._01e(b.x,a),(new f.e)._01e(this.f,this.a));this.g=(new t)._0dM((new f.e)._01e(b.g(),a),(new f.e)._01e(this.e,this.a))},C:function(c,b){var a=!1,h=b[0].y,g=b[2].y,d=b;if(c.bi<this.t||0==c.bs){if(h<this.a&&
b[2].x==b[3].x)return d=f.e._ca(6),d[0]._i1(this.g.a(h),h),d[1]._i1(this.h.a(h),h),d[2]._i1(this.h.a(this.a),this.a),d[3]._i1(d[2].x,g),d[5]._i1(this.g.a(this.a),this.a),d[4]._i1(d[5].x,g),d;b[0]._i1(this.f,h);b[1]._i1(this.e,h);a=!0}c.a2<this.t?(b[2]._i1(this.e,g),b[3]._i1(this.f,g)):a&&this.a<g?(d=f.e._ca(6),d[0]._i1(this.g.a(h),h),d[1]._i1(this.h.a(h),h),d[2]._i1(this.f,this.a),d[3]._i1(this.f,g),d[4]._i1(this.e,g),d[5]._i1(this.e,this.a)):(b[0]._i1(this.g.a(h),h),b[1]._i1(this.h.a(h),h),b[2]._i1(this.h.a(g),
g),b[3]._i1(this.g.a(g),g));return d},B:function(c,b,a,h,g,d,w,m,n){if(!c.P){var e=new s.ba,m=c.b.a._nc(),i=m.h,k=m.f;c.g(256)&&(i=0);switch(k){case 0:e.a=this.d?g.a:h.a;break;case 2:e.a=this.d?h.a:g.a;break;default:e.a=f.u.z(h.a+g.a,2)}h=c.by();this.l?1!=i?(n=j.j(e.a-w,f.u.z(b,2),a),e.b=(this.d?0==i:2==i)?d-n:d+n,e.b=2==i?e.b-f.u.z(c.aN,2):e.b+f.u.z(c.aN,2)):e.b=d:(d=k=0,2==i?(e.b=n.g(),d=-2,k=e.a>this.a?this.e:this.g.a(e.a),k+=4,i=0):(e.b=n.x,d=2,k=e.a>this.a?this.f:this.h.a(e.a),k-=4,i=2),0!=this.m.d?
(n=f.m.b._nc(),this.o&&n._cf(c.n.d()),n=this.m.c(n._nc()),c.c.idq(n,k,e.a,e.b+d,e.a),n._d()):e.b=k,k=1);e.c=f.u.z(c.a.f,2);e=c.f.ici(e);h=c.a3(c.h,h);n=0;m.i&&(n=4096);m=(new s.cE)._02cE(m.a._nc(),i,k,n);c.a6(m,h,e._nc());m._d()}},A:function(c,b,a,h,g,d,w){var m=null,n=null,m=n=null,e=0,i=0,k=0,p=0,r=0,l=0,q=0,e=l=i=e=0,p=new s.ba,r=new s.ba;p._cf(b);r._cf(a);n=s.ba._ca(4);m=s.ba._ca(4);s.ba._ca(4);p=f.u.z(b.b+a.b,2);r=f.u.z(b.a+a.a,2);l=f.u.z(b.c+a.c,2);h=0!=(h&8);e=0!=(b.b+a.b&1);h&&(j.w(b,p,r),
j.w(a,p,r),b.b>a.b&&(i=new f._p2(b.b,a.b),j.x(i),b.b=i.a,a.b=i.b),e&&a.a--);q=a.a-b.a;e=a.b-b.b;i=a.c-b.c;e=f.u.z(e,2);i=f.u.z(i,2);if(0!=g){var t=0,o=0,t=j.j(d,e,g),o=j.j(d,i,g),k=new f._p1(k);j.r(k,4,p,a.a,l,e-t,i-o,n,-1);k=k.a;t=j.j(d+q,e,g);o=j.j(d+q,i,g);d=new f._p1(k);j.r(d,4,p,b.a,l,e-t,i-o,m,-1)}else{d=new f._p1(k);j.r(d,4,p,a.a,l,e,i,n,a.b);for(l=0;4>l;l++)m[l]._cf(n[l]);for(l=0;4>l;l++)m[l].a=b.a}e=4;d=null;if(0!=g&&(d=f.e._ca(e),d[0].x=n[1].b,d[0].y=a.a,d[1].x=n[3].b,d[1].y=a.a,d[2].y=
b.a,d[2].x=m[3].b,d[3].x=m[1].b,d[3].y=b.a,h))for(l=0;l<e;l++)j.z(d[l],p,r);if(a.a!=b.a)if(d=this.C(w,d),b=f.d.b._nc(),null!=this.b){for(c=this.b.id().Sb();!0==c.SI();)switch(a=c.SK(),a.bA()){case "P":case "PointsPolygon":a.sa(d);break;default:this.b.l(a,w,this,b)}c=f.d.b._nc();this.b.q(w.c,c,1,0)}else c.idN(w.x,d),c.idu(w.n,d)},i:function(){null!=this.q&&this.q.iaf(16777248)},y:function(c){c=c.a;0==c.b&&(c.b=1);0==c.c&&(c.c=1);return null},toString:function(){return"Funnel"}};j.j=function(c,b,a){return f.u.z(c*
b,a)};j.r=function(c,b,a,h,g,d,j,m,n){for(var e=0,i=0,k=0,p=k=i=0,r=0,l=0,q=0,b=f.a.n(f.a.d(b),2),b=f.a.o(b,4),q=2*f.a.c/b,p=f.a.q(q),r=f.a.h(q),i=1,e=k=0;e<b;e++)m[e].a=h,m[e].b=a+f.a.j(d*k+0.5),m[e].c=g+f.a.j(j*i+0.5),l=i*r+k*p,k=k*r-i*p,i=l;c.a=q;if(-1!=n){i=f.u.c;k=-1;for(e=0;e<b;e++)m[e].b>i&&(k=e,i=m[e].b);if(-1!=k)for(e=0;e<b;e++)m[e].b==i&&(m[e].b=n)}return b};j.w=function(c,b,a){var f=c.b;c.b=b+(a-c.a);c.a=a-(b-f)};j.z=function(c,b,a){var f=c.x;c.x=b+(a-c.y);c.y=a-(b-f)};j.x=function(c){var b=
c.a;c.a=c.b;c.b=b};j._dt("CWGF",f.Sy,0,s.icT,s.ieF)})();
