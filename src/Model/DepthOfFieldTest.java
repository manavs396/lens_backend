package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class test the formulas implemented in DOF class, Lens
 * by comparing with expected values.
 */

class DepthOfFieldTest {


    Lens test_lens1 = new Lens("Canon", 1.8, 50);
    Lens test_lens2 = new Lens("Tamron", 2.8, 90);
    Lens test_lens3 = new Lens( "Nikon", 2.8, 200);

    @Test
    void getAperature() {
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(1.8 , dof.getAperture());
    }

    @Test
    void  getLens_type(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1,1.8);
        assertEquals(test_lens1, dof.getLens_type());
    }
    @Test
    void getDis_sub(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(1.1, dof.getDis_sub());
    }

    @Test
     void Hyperfocal(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(47892.72, dof.Hyperfocal(), 0.1);
    }

    @Test
    void Nearfocal(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(1076.4 , dof.Nearfocal(), 0.1);
    }

    @Test
    void Farfocal(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(1124.65, dof.Farfocal() , 0.1);
    }

    @Test
    void depthoffield(){
        DepthOfField dof = new DepthOfField(test_lens1, 1.1, 1.8);
        assertEquals(48.25 , dof.depthoffield() , 0.1);
    }

    @Test
    void getAperature1() {
        DepthOfField dof = new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(2.8 , dof.getAperture());
    }

    @Test
    void getLens_type1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.1,2.8);
        assertEquals(test_lens2, dof.getLens_type());
    }

    @Test
    void getDis_sub1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.5, 2.8);
        assertEquals(1.5, dof.getDis_sub());
    }

    @Test
    void Hyperfocal1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(99753.69, dof.Hyperfocal(), 0.1);
    }

    @Test
    void Nearfocal1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(1088.97 , dof.Nearfocal(), 0.1);
    }

    @Test
    void Farfocal1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(1111.25, dof.Farfocal() , 0.1);
    }

    @Test
    void depthoffield1(){
        DepthOfField dof = new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(22.28 , dof.depthoffield() , 0.1);
    }

    @Test
    void getAperature2() {
        DepthOfField dof = new DepthOfField(test_lens3, 1.1, 2.8);
        assertEquals(2.8 , dof.getAperture());
    }

    @Test
    void  getLens_type2(){
        DepthOfField dof = new DepthOfField(test_lens3, 1.1,2.8);
        assertEquals(test_lens3, dof.getLens_type());
    }

    @Test
    void getDis_sub2(){
        DepthOfField dof = new DepthOfField(test_lens3, 1.5, 2.8);
        assertEquals(1.5, dof.getDis_sub());
    }

    @Test
    void Hyperfocal2(){
        DepthOfField dof = new DepthOfField(test_lens3, 1.1, 2.8);
        assertEquals(492610.83, dof.Hyperfocal(), 0.1);
    }

    @Test
    void Nearfocal2(){
        DepthOfField dof = new DepthOfField(test_lens3, 1.1, 2.8);
        assertEquals(1097.99 , dof.Nearfocal(), 0.1);
    }

    @Test
    void Farfocal2(){
        double inf = Double.POSITIVE_INFINITY;
        DepthOfField dof = new DepthOfField(test_lens3, 1.1, 2.8);
        assertEquals(1102.01, dof.Farfocal() , 0.1);
        DepthOfField dof1 = new DepthOfField(test_lens3, 50000, 2.8);
        assertEquals( inf ,dof1.Farfocal(),0.1);
    }

    @Test
    void depthoffield2(){
        DepthOfField dof = new DepthOfField(test_lens3, 1.1, 2.8);
        assertEquals(4.01 , dof.depthoffield() , 0.1);
    }
    @Test
    void getCoc(){
        DepthOfField dof = new DepthOfField(test_lens2,1.1, 2.8);
        assertEquals(0.029,dof.getCoc());
    }
    @Test
    void test_constructor(){
        DepthOfField dof= new DepthOfField(test_lens2, 1.1, 2.8);
        assertEquals(1.1,dof.getDis_sub());
        assertEquals(2.8,dof.getAperture());
        assertEquals( test_lens2,  dof.getLens_type());
    }
    @Test
    void test_constructor1(){
        try {
            DepthOfField dof = new DepthOfField(null, -1.1, 0);
        }
        catch (IllegalArgumentException e){
            assertTrue(true);
        }
    }

    @Test
    void test_subject_distance() {
        Lens test_lens4 = new Lens(" Canon", 1.1, 9);
        try {
            DepthOfField dof = new DepthOfField(test_lens4, -2, 1.1);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void test_aperture(){
        Lens test_lens4 = new Lens("Canon",-20,10);
        try{
            DepthOfField dof = new DepthOfField(test_lens4,1.1,-20);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void test_aperture1(){
        Lens test_lens4= new Lens("Canon", 10,20);
        try{
            DepthOfField dof = new DepthOfField(test_lens4,1.1, 5);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }

    }
    @Test
    void get_test_lens(){
        Lens test_lens = new Lens("Cannon", 10, 20);
        assertEquals("Cannon", test_lens.getMake_lens());
        assertEquals(10, test_lens.getMax_aperture());
        assertEquals(20,test_lens.getLens_focal());
    }

    @Test
    void set_test_lens(){
        test_lens1.setMake_lens("ABC");
        assertEquals("ABC",test_lens1.getMake_lens());
        test_lens1.setLens_focal(100);
        assertEquals(100,test_lens1.getLens_focal());
        test_lens1.setMax_aperture(20);
        assertEquals(20,test_lens1.getMax_aperture());
    }

}