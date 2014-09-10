package generic.generic3;
/**
 * 
 * T F 都是泛型 , F 其实也是T 的意思 ()
 * @author junezh
 *
 * @param <T>
 * @param <F>
 */
public interface IGeniric<T, F> {
	
	T compare(F f);
	

}
