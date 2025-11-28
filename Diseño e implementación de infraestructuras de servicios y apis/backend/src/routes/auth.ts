import { Router } from 'express';
import { prisma } from '../prisma';
import * as bcrypt from 'bcrypt';
import * as jwt from 'jsonwebtoken';
import * as dotenv from 'dotenv';
dotenv.config();
const router = Router();
// Registro
router.post('/register', async (req, res) => {
const { email, password } = req.body;
const hashed = await bcrypt.hash(password, 10);
const user = await prisma.user.create({ data: { email, password: hashed } });
res.json({ id: user.id, email: user.email });
});
// Login
4
router.post('/login', async (req, res) => {
const { email, password } = req.body;
const user = await prisma.user.findUnique({ where: { email } });
if (!user) return res.status(400).json({ message: 'User not found' });
const valid = await bcrypt.compare(password, user.password);
if (!valid) return res.status(400).json({ message: 'Wrong password' });
const token = jwt.sign({ id: user.id, email: user.email }, process.env.JWT_SECRET as string, { expiresIn: '1h' });
res.json({ token });
});
export default router;