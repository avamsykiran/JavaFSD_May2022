import Arth from "./Arth";

test('Arth Instance',()=>{
    expect(Arth).toBeTruthy();
})

test('Arth.sum shall return 2 given 1 and 1',()=>{
    expect(Arth.sum(1,1)).toBe(2);
})