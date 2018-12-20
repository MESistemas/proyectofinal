/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.gestionAlumnos.gestionalumnos.views.xlsx;

import com.analistas.gestionalumnos.gestionalumnos.models.entitys.nota.Nota;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 *
 * @author matia
 */
@Component("notas/ver.xlsx")
public class NotasXlsx extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook wrkbk, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        Nota nota = (Nota) map.get("listado");
        Sheet sheet = wrkbk.createSheet();
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);

        cell.setCellValue("Alumno");
        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(nota.getAlumno().getApellido() + ", " + nota.getAlumno().getNombre());

        cell.setCellValue("Nota");
        row = sheet.createRow(1);
        cell = row.createCell(1);
        cell.setCellValue(nota.getNota());
        
        cell.setCellValue("Descripcion");
        row = sheet.createRow(1);
        cell = row.createCell(2);
        cell.setCellValue(nota.getDescripcion());
        
        cell.setCellValue("Materia");
        row = sheet.createRow(1);
        cell = row.createCell(3);
        cell.setCellValue(nota.getMateria().getNombre_Materia());
        
        cell.setCellValue("Curso");
        row = sheet.createRow(1);
        cell = row.createCell(4);
        cell.setCellValue(nota.getMateria().getCurso().getNombre_Curso() + "" + nota.getMateria().getCurso().getDivision().getNombre_Division());
        
    }

}
