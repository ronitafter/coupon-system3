import React from 'react'



function AddCompany() {

  const [show, setShow] = useState(false);
  const [success, setSuccess] = useState(false);
  const handleShow = () => setShow(true);
  const handleClose = () => setShow(false);

  const {
    register,
    handleSubmit,
    setValue,
    reset,
    formState: { errors }
  } = useForm();

  const NewCompany = (data) => {
    fetch(`http://localhost:3000/companies`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data),
    })
      .then(res => res.json())
      .then(data => {
        if (data.result.ok) {
          setSuccess(true);
          reset();
        } else {
          setSuccess(false);
        }
      });
  }

  const onSubmit = (data) => {
    NewCompany(data);
  };

  const randomCode = () => {
    let code = Math.random().toString(36).substr(2, 8).toUpperCase();
    setValue('code', code, { shouldValidate: true });
  }



  return (

    <>
      <Button variant="primary" className="float-end mb-4" onClick={handleShow}>+ Add Company</Button>
      <Modal show={show} onHide={handleClose}>
        <Form noValidate onSubmit={handleSubmit(onSubmit)}>
          <Modal.Header closeButton>
            <Modal.Title>New Company</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            {success && <Alert variant="success" onClose={() => setSuccess(false)} dismissible>Success!</Alert>}
            <Form.Group controlId="formCode">
              <Form.Label>Code</Form.Label>
              <InputGroup className="mb-3" hasValidation>
                <Form.Control type="text" isInvalid={errors.code} {...register("code", { required: true })} />
                <Button variant="secondary" onClick={randomCode}>
                </Button>
                {errors.code && <Form.Control.Feedback type="invalid">This field is required</Form.Control.Feedback>}
              </InputGroup>
            </Form.Group>
            <Form.Group controlId="formCode">
              <Form.Label>Write something here...</Form.Label>
              <InputGroup className="mb-3">
                <Form.Control type="date" {...register("expireDate")} />
              </InputGroup>
            </Form.Group>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" type="button" onClick={handleClose}>Close</Button>
            <Button variant="primary" type="submit">Add Company</Button>
          </Modal.Footer>
        </Form>
      </Modal>
    </>
  )
}

export default AddCompany