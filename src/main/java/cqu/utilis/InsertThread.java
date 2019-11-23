package cqu.utilis;

import cqu.dao.DetailsDao;
import cqu.domain.Details;
import cqu.domain.InsertStudnets;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class InsertThread extends Thread {

    private DetailsDao detailsDao;

    public InsertThread(List<List<Object>> listob, Map<String, Integer> index, int start, int end, DetailsDao detailsDao) {
        this.detailsDao = detailsDao;
        this.listob = listob;
        this.index = index;
        this.start = start;
        this.end = end;
    }

    private List<List<Object>> listob;
    private Map<String, Integer> index;
    private int start;
    private int end;

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            List<Object> lo = listob.get(i);
            InsertStudnets vo = new InsertStudnets();
            try {
                vo.setProject(String.valueOf(lo.get(index.get("项目"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setSubject(String.valueOf(lo.get(index.get("科目"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setClassId(String.valueOf(lo.get(index.get("班号"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setTeacher(String.valueOf(lo.get(index.get("老师"))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setStudentsId(String.valueOf(String.valueOf(lo.get(index.get("学员号")))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setStudentsName(String.valueOf(String.valueOf(lo.get(index.get("学员姓名")))));
            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                vo.setIsContinue(DetailsUtils.stringToInteger(String.valueOf(lo.get(index.get("是否续报春季班")))));
            } catch (Exception e) {
            }
            List<Details> studentsByStudentsName = null;
            try {
                studentsByStudentsName = detailsDao.findStudentsByStudentsId(String.valueOf(lo.get(index.get("班号"))), String.valueOf(lo.get(index.get("学员号"))));
            } catch (Exception e) {
            }
            if (studentsByStudentsName != null && studentsByStudentsName.size() > 0) {
                try {
                    vo.setNps(String.valueOf(Double.valueOf(String.valueOf(lo.get(index.get("NPS")))) * 100) + "%");
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println(vo);
                detailsDao.update(vo);
            } else {
                detailsDao.insert(vo);
            }
        }
        index.put("message", index.get("message") + 1);
    }
     /*if (listob.size()<3000){
            new InsertThread(listob,index,0,listob.size(),detailsDao).start();
            try {
            while (index.get("message")!=1){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(listob.size()<6000){
            new InsertThread(listob,index,2,3000,detailsDao).start();
            new InsertThread(listob,index,3000,listob.size(),detailsDao).start();
            try {
                while (index.get("message")!=2){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(listob.size()<9000){
            new InsertThread(listob,index,2,3000,detailsDao).start();
            new InsertThread(listob,index,3000,6000,detailsDao).start();
            new InsertThread(listob,index,6000,listob.size(),detailsDao).start();
            try {
                while (index.get("message")!=3){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(listob.size()<12000){
            new InsertThread(listob,index,2,3000,detailsDao).start();
            new InsertThread(listob,index,3000,6000,detailsDao).start();
            new InsertThread(listob,index,6000,9000,detailsDao).start();
            new InsertThread(listob,index,9000,listob.size(),detailsDao).start();
            try {
                while (index.get("message")!=4){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if(listob.size()<15000){
            new InsertThread(listob,index,2,3000,detailsDao).start();
            new InsertThread(listob,index,3000,6000,detailsDao).start();
            new InsertThread(listob,index,6000,9000,detailsDao).start();
            new InsertThread(listob,index,9000,12000,detailsDao).start();
            new InsertThread(listob,index,12000,listob.size(),detailsDao).start();
            try {
                while (index.get("message")!=5){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            new InsertThread(listob,index,2,3000,detailsDao).start();
            new InsertThread(listob,index,3000,6000,detailsDao).start();
            new InsertThread(listob,index,6000,9000,detailsDao).start();
            new InsertThread(listob,index,9000,12000,detailsDao).start();
            new InsertThread(listob,index,12000,15000,detailsDao).start();
            new InsertThread(listob,index,15000,listob.size(),detailsDao).start();
            try {
                while (index.get("message")!=6){
                    TimeUnit.SECONDS.sleep(10);
                } } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
}
