import { Component, EventEmitter, Output } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NoteDto } from '../../../core/models/NoteDto';
import { NoteService } from '../../../core/services/notes/note.service';
@Component({
  selector: 'app-create-form',
  imports: [ReactiveFormsModule],
  templateUrl: './create-form.component.html',
  styleUrl: './create-form.component.css'
})
export class CreateFormComponent {

  constructor(private notesService:NoteService){
  }

  @Output() close = new EventEmitter<boolean>();
  
  noteForm = new FormGroup({
    name: new FormControl<string>('', [Validators.required, Validators.minLength(1)]),
    description: new FormControl<string>('', [Validators.required, Validators.minLength(1)])
  });

  // Mandar al padre el estado del PopUp para permitir cerrarlo desde el componente hijo (este mismo)
  closePopup() {
    this.close.emit();
  }

  submitForm() {
    const note: NoteDto = this.noteForm.value as NoteDto;
    this.notesService.addNote(note).subscribe({
      next: note => console.log("Nota agregada correctamente", note),
      error: err => console.log("Error: ", err)
    });
  }
}
