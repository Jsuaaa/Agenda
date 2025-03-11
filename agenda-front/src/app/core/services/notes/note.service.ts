import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalConstants } from '../../../global.const';
import { NoteDto } from '../../models/NoteDto';
import { HttpClient } from '@angular/common/http';

const URL = GlobalConstants.BASIC_URL;

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  constructor(private http:HttpClient) { }

  getAllNotes(): Observable<any[]>{
    return this.http.get<any[]>(URL + "notes");
  }

  getNoteById(id:number): Observable<any>{
    return this.http.get<any>(URL + "notes/" + id);
  }

  addNote(noteDto:NoteDto): Observable<any>{
    return this.http.post(URL + "notes/create", noteDto);
  }

  updateNote(id:number, noteDto:NoteDto): Observable<any>{
    return this.http.put(URL + "notes/update/" + id, noteDto);
  }

  deleteNote(id:number): Observable<any>{
    return this.http.delete(URL + "notes/delete/" + id);
  }
}
