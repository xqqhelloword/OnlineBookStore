package service;

public class Operate<E> {                  //测试用的东西，无用
	//增
		public void add(E x){
			
		}
		//删
		public void delete(int id){
			 
		}
		public void delete(E obj){
			 
		}
		//查
		public E findByID(E e){
			e.getClass();
			return null;
		}
		public E findByName(String name){
			return null;
		}
		
		public E findByConditions(String where){
			return null;
		}
		
		//改
		public void update(E obj){
			
		}
		public static<E> void update1(E obj){//静态方法不能用类上定义的泛型参数，但可以自己定义泛型,这里的E和类上的E是两码事。
			
		}

}
