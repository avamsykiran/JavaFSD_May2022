import { InWordsPipe } from './in-words.pipe';

describe('InWordsPipe', () => {
  
  it('create an instance', () => {
    const pipe = new InWordsPipe();
    expect(pipe).toBeTruthy();
  });

  it('shall return ONE given 1', () => {
    const pipe = new InWordsPipe();
    expect(pipe.transform(1)).toBe("ONE");
  });

  it('shall return UNKNOWN given 10', () => {
    const pipe = new InWordsPipe();
    expect(pipe.transform(10)).toBe("UNKNOWN");
  });
});
