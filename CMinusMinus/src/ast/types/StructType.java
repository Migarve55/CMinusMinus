package ast.types;

import java.util.List;

import ast.Type;
import ast.definitions.VariableDefinition;
import semantic.AstVisitor;

public class StructType extends AbstractType {
	
	private List<VariableDefinition> fields;

	public StructType(List<VariableDefinition> fields) {
		super();
		this.fields = fields;
	}

	public List<VariableDefinition> getFields() {
		return fields;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		getFields().forEach(def -> sb.append(String.format("\t%s:%s%n", def.getName(), def.getType())));
		sb.append("}\n");
		return sb.toString();
	}
	
	@Override
	public <TP, TR> TR accept(AstVisitor<TP, TR> visitor, TP param) {
		return visitor.denunciaDelPrincipado(this, param);
	}

	@Override
	public int getBytesSize() {
		return fields.stream()
				.map(vd -> vd.getType().getBytesSize())
				.mapToInt(Integer::intValue).sum();
	}
	
	@Override
	public String getMAPLSuffix() {
		return null;
	}

	@Override
	public Type dot(String field) {
		for (VariableDefinition varDef : fields)
			if (varDef.getName().equals(field))
				return varDef.getType();
		return new ErrorType(parent, "can not find field: " + field);
	}
	
	public int getOffsetForField(String field) {
		for (VariableDefinition varDef : fields)
			if (varDef.getName().equals(field))
				return varDef.getOffset();
		throw new IllegalArgumentException("no field with that name");
	}
	
	@Override
	public Type address() {
		return new PointerType(this);
	}

}
